package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_5567 {

    static int n, m, answer;
    static List<List<Integer>> list = new ArrayList<>();
    static boolean[] visited;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static Queue<Integer[]> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];

        for(int i = 0 ; i <= n ; i++) {
            list.add(new ArrayList<>());
        }

        for(int i = 0; i < m ; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        visited[1] = true;
        q.offer(new Integer[]{1, 0});

        while(!q.isEmpty()) {
            Integer[] out = q.poll();
            Integer v = out[0];
            Integer step = out[1];

            if(1 <= step && step <= 2) {
                answer++;
            }else if(step > 2) {
                break;
            }

            for(Integer u: list.get(v)) {
                if(visited[u]) {
                    continue;
                }

                visited[u] = true;
                q.offer(new Integer[]{u, step + 1});
            }
        }

        System.out.println(answer);
    }
}
