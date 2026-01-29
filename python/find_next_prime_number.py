def is_prime_number(i):
    for j in range(2, i):
        if i % j == 0:
            return False
    return True

def find_next_prime_number():
    prime_number = 1
    while True:
        decision = input("Find the next prime number? (Y/N) ").upper()[0]
        if decision == 'N':
            break
        next_prime_number_found, current_number = False, prime_number + 1
        while not next_prime_number_found:
            if is_prime_number(current_number):
                print(current_number)
                prime_number = current_number
                next_prime_number_found = True
            else:
                current_number += 1

find_next_prime_number()
