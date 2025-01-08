package org.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 그래프 그리고 1번부터 bfs 시작하는데 꺼낼 때마다 num, dist, cnt를 갱신해주면 됨.
 */
public class Q_6118 {

    static int N, M, num, dist, cnt;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static Queue<int[]> queue = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];

        for(int i = 0; i <= N; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            list.get(u).add(v);
            list.get(v).add(u);
        }


        visited[1] = true;
        queue.offer(new int[]{1, 0});

        num = 0;
        dist = 0;
        cnt = 1;

        while(!queue.isEmpty()) {
            int[] node = queue.poll();
            int n = node[0];
            int d = node[1];

            if(dist < d) {
                num = n;
                dist = d;
                cnt = 1;
            } else if(dist == d) {
                num = Math.min(num, n);
                cnt++;
            }

            for(int v: list.get(n)) {
                if(visited[v]) {
                    continue;
                }

                visited[v] = true;
                queue.offer(new int[]{v, d + 1});
            }
        }

        System.out.printf("%d %d %d", num, dist, cnt);
    }
}
