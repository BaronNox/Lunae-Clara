package net.noxumbrarum.lunaeclara.util;

public class Pair<V, W> {
	V value1;
	W value2;
	
	public Pair() {
	}
	
	public Pair(V value1, W value2) {
		this.value1 = value1;
		this.value2 = value2;
	}
	
	public void setValue1(V value1) {
		this.value1 = value1;
	}
	
	public void setValue2(W value2) {
		this.value2 = value2;
	}
	
	public V getFirst() {
		return value1;
	}
	
	public W getSecond() {
		return value2;
	}
}
