package com.ben.thread;

import java.util.Map;
import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public interface MyConcurrentMap<K, V> extends Map<K, V> {
	default V getOrDefault(Object key, V defaultValue) {
		V v;
		return ((v = get(key)) != null) ? v : defaultValue;
	}
	
	@Override
	default void forEach(BiConsumer<? super K, ? super V> action) {
		Objects.requireNonNull(action);
		for (Map.Entry<K, V> entry : entrySet()) {
			K k;
			V v;
			try {
				k = entry.getKey();
				v = entry.getValue();
			}catch(IllegalStateException ise) {
                // this usually means the entry is no longer in the map.
                continue;
            }
			action.accept(k, v);
		}
	}
	
	boolean replace(K key, V oldValue, V newValue);
	
	
	@Override
	default void replaceAll(BiFunction<? super K, ? super V, ? extends V> function ) {
		Objects.requireNonNull(function);
		forEach((k, v) -> {
			while (!replace(k, v, function.apply(k, v))) {
				// v changed or k is gone
				if ((v = get(k)) == null) {
					// k is no longer in the map.
					break;
				}
			}
		});
	}
	
	@Override 
	default V computeIfAbsent(K key,Function<? super K, ? extends V> mappingFunction) {
		Objects.requireNonNull(mappingFunction);
		V v, newValue;
		return ((v = get(key)) == null && 
				(newValue = mappingFunction.apply(key)) != null && 
				(v = putIfAbsent(key, newValue)) == null) ? newValue : v;
	}
	
	@Override 
	public default V computeIfPresent(K key,BiFunction<? super K, ? super V, ? extends V> remappingFunction) {
		Objects.requireNonNull(remappingFunction);
		V oldValue;
		while ((oldValue = get(key)) != null) {
			V newValue = remappingFunction.apply(key, oldValue);
			if (newValue != null) {
				if (replace(key, oldValue, newValue)) {
					return newValue;
				}
			} else if (remove(key, oldValue)) {
				return oldValue;
			}
		}
		return oldValue;
	}
}
