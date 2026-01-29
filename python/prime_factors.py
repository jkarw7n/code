def prime_factors_of(i):
    prime_factors = []
    while i != 1:
        for j in range(2, i + 1):
            while i % j == 0:
                prime_factors.append(j)
                i /= j
    return prime_factors

integer = int(input("Enter an integer: "))
prime_factors = prime_factors_of(integer)
factorS = "factors" if len(prime_factors) != 0 else "factor"
isAre = "are" if len(prime_factors) != 0 else "is"
print(f"The prime {factorS} of {integer} {isAre} {', '.join(map(str, prime_factors))}, and {str(prime_factors[-1])}.")
