# Linear Regression from scratch

# Dataset
X = [1, 2, 3, 4, 5]
Y = [2, 4, 5, 4, 5]

n = len(X)

# Calculate mean
x_mean = sum(X) / n
y_mean = sum(Y) / n

# Calculate slope (m)
numerator = 0
denominator = 0

for i in range(n):
    numerator += (X[i] - x_mean) * (Y[i] - y_mean)
    denominator += (X[i] - x_mean) ** 2

m = numerator / denominator

# Calculate intercept (c)
c = y_mean - m * x_mean

# Print equation
print("Slope:", m)
print("Intercept:", c)
print("Equation: Y =", m, "* X +", c)

# Prediction
x_new = 6
y_pred = m * x_new + c

print("Prediction for X =", x_new, ":", y_pred)
