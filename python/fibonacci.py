def fibonacci(i):
    printed, stored, passed = 1, 0, None
    for j in range(i):
        print(f"{printed}", end=" ")
        passed = printed
        printed += stored
        stored = passed

integer = int(input("Enter an integer: "))
fibonacci(integer)
