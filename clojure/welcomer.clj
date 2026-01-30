(ns clojure.welcomer)

(defn welcome [& people]
  (doseq [person people]
    (println (clojure.string/join "" ["Hello " person "!"]))
  )
)

(welcome "Mark" "Allyszah" "Paul Jan" "Ricardo")
; welcomes each person in the arguments
; Hello Mark!
; Hello Allyszah!
; etc...
