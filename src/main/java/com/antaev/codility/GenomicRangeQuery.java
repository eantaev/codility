package com.antaev.codility;

public final class GenomicRangeQuery {
    public enum Nucleotide {
        A(1), C(2), G(3), T(4);
        public final char code;
        public final int cost;

        Nucleotide(int cost) {
            this.code = name().charAt(0);
            this.cost = cost;
        }

    }

    private static final Nucleotide[] nucleotides = Nucleotide.values();

    public static Nucleotide parseNucleotide(char c) {
        for (Nucleotide n : nucleotides) {
            if (n.code == c) {
                return n;
            }
        }
        throw new IllegalArgumentException("Unknown nucleotide " + c);
    }

    public static final class SearchIndex {
        private final String dna;
        private final int[] nextSmaller;

        private SearchIndex(String dna) {
            this.dna = dna;
            this.nextSmaller = buildIndex(dna);
        }

        private static int[] buildIndex(String S) {
            // build search index
            int[] nextSmaller = new int[S.length()];
            int[] lastPosition = new int[nucleotides.length];
            for (int i = 0; i < nucleotides.length; ++i) {
                lastPosition[i] = Integer.MAX_VALUE;
            }
            for (int i = S.length() - 1; i >= 0; --i) {
                Nucleotide s = parseNucleotide(S.charAt(i));
                int nextSmallerPos = Integer.MAX_VALUE;
                for (int j = s.ordinal() - 1; j >= 0; --j) {
                    nextSmallerPos = Math.min(nextSmallerPos, lastPosition[j]);
                }
                nextSmaller[i] = nextSmallerPos;
                lastPosition[s.ordinal()] = i;
            }
            return nextSmaller;
        }

        public int cost(int startInclusive, int endInclusive) {
            int cost = Integer.MAX_VALUE;
            int pos = startInclusive; // next position to consider for min value
            while (pos <= endInclusive) {
                cost = Math.min(cost, parseNucleotide(dna.charAt(pos)).cost);
                pos = nextSmaller[pos];
            }
            return cost;
        }
    }

    public int[] solution(String S, int[] P, int[] Q) {
        SearchIndex idx = new SearchIndex(S);
        // execute queries
        int numQueries = P.length;
        int[] results = new int[numQueries];
        for (int i = 0; i < numQueries; ++i) {
            results[i] = idx.cost(P[i], Q[i]);
        }
        return results;
    }
}
