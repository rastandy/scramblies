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
            str2-chars (keys str2-freq-map)
            str2-freq-vals (vals str2-freq-map)]
        (first (drop-while #(not= str2-freq-map (select-keys % str2-chars))
                           (reductions (fn [counts x]
                                         (assoc counts x (inc (get counts x 0))))
                                       {}
                                       str1)))))))
