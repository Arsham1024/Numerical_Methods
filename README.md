# Numerical Methods
##### I developed these algorithms to find approximate the value of the root(s) of a function: 1. Bisection 2. False-Position 3. Secant 4. Modified-Secant 5. Newton

This was done for CS 3010 Numerical Methods
---
### Description:
###### All of these methods are used to approximate the value of a root of a function, These are all itterative methods that can converge to a specific root or diverge if the inital value is not chosen correctly. There is an accompanying write up doc for more explanation.
---
### Specifications:
###### These methods are very similar to each other with minor difference. 
###### Both methods will run 50 times maximum.
###### There are 2 functions to solve.
---
### Functions:

---
### How:
#### There are couple of checks that need to be done before we begin:
1. Writing equations on top of each other there must be no zero terms along the diagonal if there are rearange the equations.
2. Solve each equation for x<sub>i</sub> starting from i = 1. so the first equation is in terms of X<sub>1</sub> and so on.
3. start from an initial guess. here my initial values are all zeros: x<sub>1</sub> = 0 , x<sub>2</sub> = 0 , x<sub>3</sub> = 0  
#### Jacobi : 
1. use the initial guess to find x<sub>i</sub> for all there equations
2. replace the x<sub>i</sub> answers in a vector and use the found answers as the input guess for the next itteration.
3. repeat 50 times

#### Gauss-Seidel: 
1. This method is almost exactly the same in the first step. find the first equation's answers based on initial guess.
2. Immedietly substitute the answer for x<sub>1</sub> into the vector to use for x<sub>2</sub>.
3. Immedietly substitute the answer for x<sub>2</sub> into the vector to use for x<sub>3</sub>
4. repeat these steps 50 times.

---
### Used: 
* Java
* No helping packages or implementations

