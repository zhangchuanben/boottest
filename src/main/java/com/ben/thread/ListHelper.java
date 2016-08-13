package com.ben.thread;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.ben.thread.annotations.ThreadSafe;

@ThreadSafe
public class ListHelper<E> {
	public List<E> list = 
			Collections.synchronizedList(new ArrayList<E>());
	public boolean putIfAbsent(E x) {
		// 为了保证线程安全，要保证以下代码块和{@code list}拥有相同的锁
		synchronized (list) {
			if (!list.contains(x)) {
				list.add(x);
				return true;
			}
			return false;
		}
	}
}
