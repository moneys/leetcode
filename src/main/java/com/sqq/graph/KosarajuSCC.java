package com.sqq.graph;

/**
 * 计算强连通分量的Kosaraju算法
 *
 * @Author: qianqian.sun
 * @Date: 2016/11/25
 */
public class KosarajuSCC {
	private boolean[] marked; // 以访问过的顶点
	private int[] id;   // 强连通分量的标识符
	private int count; // 强连通分量的数量

	public KosarajuSCC(Digraph G) {
		marked = new boolean[G.V()];
		id = new int[G.V()];
		DepthFirstOrder order = new DepthFirstOrder(G.reverse());
		for (int s : order.reversePost()) {
			if (!marked[s]) {
				dfs(G, s);
				count++;
			}
		}
	}

	private void dfs(Digraph G, int v) {
		marked[v] = true;
		id[v] = count;
		for (int w : G.adj(v)) {
			if (!marked[w]) dfs(G, w);
		}
	}

	public boolean strongLyConnected(int v, int w) {
		return id[v] == id[w];
	}

	public int id(int v) {
		return id[v];
	}

	public int count() {
		return count;
	}
}
