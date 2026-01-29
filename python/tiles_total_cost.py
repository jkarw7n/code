def find_total_cost_of_tiles(length, width, cost):
    return f"₱{length * width * cost:,.2f}"

length, width, cost = float(input("Enter length: ")), float(input("Enter width: ")), float(input("Enter cost per tile: ₱"))
print(f"The total cost would be {find_total_cost_of_tiles(length, width, cost)}.")
