(ns looping-is-recursion)

(defn power [base exp]
  (let [hlpr (fn [r b e]
               (if (zero? e)
                 (* r 1)
                 (recur (* r b) b (dec e))))]
      (hlpr 1 base exp)))

(defn last-element [a-seq]
  (if (empty? (rest a-seq))
    (first a-seq)
    (recur (rest a-seq))))

(defn seq= [seq1 seq2]
  (cond
    (and (empty? seq1) (empty? seq2)) true
    (or (empty? seq1) (empty? seq2)) false
    :else (if (= (first seq1) (first seq2))
            (recur (rest seq1) (rest seq2))
            false)))

(defn seq2= [seq1 seq2]
  ())

(defn find-first-index [pred a-seq]
   (loop [idx 0
         i-seq a-seq]
   (if (not (empty? i-seq))
    (if (pred (first i-seq))
      idx
      (recur (inc idx) (rest i-seq))))))

(defn avg [a-seq]
  (loop [sum 0
         cnt 0
         sq a-seq]
    (if (empty? sq)
        (/ sum cnt)
        (recur (+ sum (first sq)) (inc cnt) (rest sq)))))

(defn parity [a-seq]
     (set (map key (filter (fn [x] (odd? (val x))) (frequencies (sort a-seq))))))

(defn fast-fibo [n]
  (loop [tc n
         addition 1
         res 0]
    (if (zero? tc)
      res
      (recur (dec tc) res (+ res addition)))))

(defn cut-at-repetition [a-seq]
  (loop [sq a-seq
         res []]
    (if (or (empty? sq) (contains? (set res) (first sq)))
      res
      (recur (rest sq) (conj res (first sq))))))

