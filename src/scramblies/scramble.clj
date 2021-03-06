(ns scramblies.scramble)

(defn scramble [str1 str2]
  (let [str1-length (count str1)
        str2-length (count str2)]
    (cond
      (= str2-length 0) true
      (> str2-length str1-length) false
      (= str1-length 0) false
      :else
      (let [str2-freq-map (frequencies str2)
            freq-map-count (count str2-freq-map)]
        (if (->> (reductions (fn [counts x]
                               (assoc counts x (inc (get counts x 0))))
                             {} str1)
                 (drop-while (fn [m] (< (count m) freq-map-count)))
                 (drop-while (fn [m]
                               (some #(> (val %) (get m (key %) 0))
                                     str2-freq-map)))
                 first)
          true
          false)))))
