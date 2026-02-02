import random

def preamble():
    print("Bagels, a deductive logic game.")
    print("By Al Sweigart al@inventwithpython.com")
    print("I am thinking of a 3-digit number. Try to guess what it is.")
    print("Here are some clues:")
    print("When I say:\tThat means:")
    print("\tPico\tOne digit is correct but in the wrong position.")
    print("\tFermi\tOne digit is correct and in the right position.")
    print("\tBagels\tNo digit is correct.")
    bagels()

def bagels():
    print("I have thought up a number.")
    print("You have 10 guesses to get it.")
    number, guesses = random.randint(100, 999), 0
    solved = False
    while guesses < 10:
        guess, clue = int(input(f"Guess #{guesses + 1}:\n> ")), None
        guess_s, number_s = str(guess), str(number)
        string = ""
        for i in range(len(guess_s)):
            if guess_s[i] in number_s:
                if guess_s[i] == number_s[i]:
                    string = string.replace("Bagels ", "") + "Fermi "
                else:
                    string = string.replace("Bagels ", "") + "Pico "
            else:
                if string == "": string += "Bagels "
        if string == "Fermi Fermi Fermi ":
            print("You got it!")
            solved = True
            break
        else:
            print(string)
        guesses += 1
    if not solved: print("You weren't able to guess the number correctly.")
    print("Do you want to play again? (yes or no)")
    decision = input()
    if decision != "yes":
        print("Thank you for playing!")
    else:
        bagels()

preamble()
