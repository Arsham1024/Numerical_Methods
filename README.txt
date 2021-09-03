# Solving-System-Linear-EQs
##### I developed these algorithms to solve linear equations using two methods: 1. gauss-seidel 2. Jacobi
This was done for CS 3010 Numerical Methods
---
### Description:
###### Gauss-Seidel method: This is an itterative method used to solve a system of linear equations
###### Jacobi method: This is also an itterative method used to solve a system of linear equations. 
---
### Specifications:
###### These methods are very similar to each other with minor difference. 
###### Both methods will run 50 times maximum.
###### There are 3 equations total and they are hard coded.
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

