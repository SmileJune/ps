package org.baekjoon;

import java.beans.Visibility;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_1707 {

    static int K, V, E;
    static List<List<Integer>> list;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] visited;
    static Queue<Integer> q;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws Exception {
        K = Integer.parseInt(br.readLine());
        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());

            visited = new int[V + 1];
            list = new ArrayList<>();
            q = new LinkedList<>();
            for(int j = 0; j <= V; j++) {
                list.add(new ArrayList<>());
            }

            for(int j = 0; j < E; j++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());

                list.get(u).add(v);
                list.get(v).add(u);
            }

            if(checkGraph()) {
                bw.write("YES");
                bw.newLine();
            } else {
                bw.write("NO");
                bw.newLine();
            }
        }

        bw.close();
    }

    static boolean checkGraph() {
        for(int j = 1; j <= V; j++) {
            if(visited[j] != 0) {
                continue;
            }
            visited[j] = 1;
            q.offer(j);

            while(!q.isEmpty()) {
                int u = q.poll();

                for(int v : list.get(u)) {
                    if(visited[v] == 0) {
                        q.offer(v);
                        visited[v] = visited[u] * (-1);
                    } else if(visited[v] == visited[u]){
                        return false;
                    }
                }
            }
        }

        return true;
    }
}
