--- binary to decimal converter
binaryToDecimal :: String -> Int
binaryToDecimal s = loop 0 0
  where
    loop digits decimal
      | digits == length s = decimal
      | otherwise = do
        let isOne = s !! digits == '1'
        let toAdd = 2 ^ (length s - digits - 1)
        loop (digits + 1) (if isOne then decimal + toAdd else decimal)

main :: IO ()
main = print (binaryToDecimal "1111111111")
