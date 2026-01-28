import pyperclip

languages = []

def copy_list():
    to_be_copied = ""
    languages.sort()
    for i in range(len(languages)):
        to_be_copied += str(i + 1) + ". " + languages[i]
    pyperclip.copy(to_be_copied)

def view_list():
    print("\n=== LANGUAGE LIST ===")
    languages.sort()
    for i in range(len(languages)):
        print(f"{i + 1}. {languages[i]}")
    print()

def enter_name():
    print("Enter language name to add to list.....")
    print("Enter VIEW to view list................")
    print("Enter COPY to copy list to clipboard...")
    print("Enter QUIT to quit.....................")
    print("=======================================")
    while True:
        language = input("Enter: ")
        if language.upper() == "QUIT":
            break
        elif language.upper() == "VIEW":
            view_list()
            continue
        elif language.upper() == "COPY":
            copy_list()
            continue
        languages.append(language)

enter_name()
