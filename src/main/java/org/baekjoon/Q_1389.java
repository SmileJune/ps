package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 각각의 노드로부터 bfs를 돌리고 최솟값을 구한다. 그리고 순차접근으로 가장 낮은 인덱스를 찾아서 출력
 */
public class Q_1389 {

    static int N, M;
    static boolean[] visited;
    static int[] arr, result;
    static List<List<Integer>> list = new ArrayList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<int[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        result = new int[N + 1];

        for(int i = 0; i <= N; i ++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list.get(u).add(v);
            list.get(v).add(u);
        }

        for(int i = 1; i <= N; i++) {
            visited = new boolean[N + 1];
            arr = new int[N + 1];

            visited[i] = true;
            q.offer(new int[]{i, 0});

            while(!q.isEmpty()) {
                int[] node = q.poll();
                int u = node[0];
                int step = node[1];
                arr[u] = step;

                for(Integer v : list.get(u)) {
                    if(visited[v]) {
                        continue;
                    }

                    visited[v] = true;
                    q.offer(new int[]{v, step + 1});
                }
            }

            int sum = 0;
            for(int j = 1; j <= N; j++) {
                sum += arr[j];
            }
            result[i] = sum;
        }

        int min = Integer.MAX_VALUE;
        int idx = 0;
        for(int i = 1; i <= N; i++) {
            if(min > result[i]) {
                min = result[i];
                idx = i;
            }
        }

        System.out.println(idx);
    }
}
