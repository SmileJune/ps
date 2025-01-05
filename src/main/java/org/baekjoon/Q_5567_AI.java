package org.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Q_5567_AI {

    static class Node {
        int vertex, step;
        Node(int vertex, int step) {
            this.vertex = vertex;
            this.step = step;
        }
    }

    static int n, m, answer;
    static List<List<Integer>> adjacencyList = new ArrayList<>();
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        visited = new boolean[n + 1];
        for (int i = 0; i <= n; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            adjacencyList.get(a).add(b);
            adjacencyList.get(b).add(a);
        }

        Queue<Node> queue = new LinkedList<>();
        visited[1] = true;
        queue.offer(new Node(1, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.step >= 2) continue; // 2단계 이상은 더 이상 큐에 추가하지 않음

            for (int neighbor : adjacencyList.get(current.vertex)) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    answer++; // 친구의 친구를 만난 경우 추가
                    queue.offer(new Node(neighbor, current.step + 1));
                }
            }
        }

        System.out.println(answer);
    }
}
