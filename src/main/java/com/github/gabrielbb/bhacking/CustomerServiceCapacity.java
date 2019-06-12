package com.github.gabrielbb.bhacking;

import java.util.*;

public class CustomerServiceCapacity {

    private static class Call {
        private long start;
        private long end;
    }

    public static void main(String[] args) {

        try (Scanner s = new Scanner(System.in)) {

            int agentsCount = s.nextInt();
            s.nextLine();
            int callsCount = s.nextInt();
            s.nextLine();

            List<Call> callsByAgent = new LinkedList<>();

            for(int i = 0; i < agentsCount; i++) {
                callsByAgent.add(new Call());
            }

            int agentsToHire = 0;

            while(callsCount-- > 0) {
                Call newCall = new Call();
                newCall.start = s.nextLong();
                newCall.end = s.nextLong();

                Optional<Call> optional = callsByAgent.stream().filter(c -> newCall.start >= c.end).findFirst();

                if(optional.isPresent()) {
                    optional.get().start = newCall.start;
                    optional.get().end = newCall.end;
                } else {
                    callsByAgent.add(newCall);
                    agentsToHire++;
                }

                s.nextLine();
            }

            System.out.println(agentsToHire);
        }
    }
}