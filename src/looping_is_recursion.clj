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
  (if (= (first seq1) (first seq2))
    (recur (rest seq1) (rest seq2))
     false))

(defn find-first-index [pred a-seq]
   (loop [idx 0
         i-seq a-seq]
   (if (not (empty? i-seq))
    (if (pred (first i-seq))
      idx
      (recur (inc idx) (rest i-seq))))))

(defn avg [a-seq]
  -1)

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  [":("])

