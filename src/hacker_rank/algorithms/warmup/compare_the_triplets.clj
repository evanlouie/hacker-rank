(ns hacker-rank.algorithms.warmup.compare-the-triplets)
(use '[clojure.string :only (split triml)])

;; https://www.hackerrank.com/challenges/compare-the-triplets/problem

(let [a0_temp (read-line)
      a0_t (split a0_temp #"\s+")
      a0 (Integer/parseInt (a0_t 0))
      a1 (Integer/parseInt (a0_t 1))
      a2 (Integer/parseInt (a0_t 2))]

  (let [b0_temp (read-line)
        b0_t (split b0_temp #"\s+")
        b0 (Integer/parseInt (b0_t 0))
        b1 (Integer/parseInt (b0_t 1))
        b2 (Integer/parseInt (b0_t 2))]
    (let [scores (->> (interleave [a0 a1 a2] [b0 b1 b2])
                      (partition 2))
          alice (reduce (fn [sum pair] (if (> (first pair) (last pair))
                                         (inc sum)
                                         sum)) 0 scores)
          bob (reduce (fn [sum pair] (if (< (first pair) (last pair))
                                       (inc sum)
                                       sum)) 0 scores)]
      (do
        (println alice bob)))))
