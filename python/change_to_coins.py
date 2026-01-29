def coin_dictionary(money):
    pennies = money * 100
    quarters = int(pennies / 25)
    pennies -= quarters * 25
    dimes = int(pennies / 10)
    pennies -= dimes * 10
    nickels = int(pennies / 5)
    pennies -= nickels * 5
    return {
        "quarters": quarters,
        "dimes": dimes,
        "nickels": nickels,
        "pennies": int(pennies)
    }

print(coin_dictionary(float(input("Enter change here: $"))))
