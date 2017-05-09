# Kyle Ottmann
# CMPT 328
# Assignment 8 - Question 3
# Program adds three numbers and displays the result
 
.data
n1: 	.asciiz "Enter 1st number: "
n2: 	.asciiz "Enter 2nd number: "
n3: 	.asciiz "Enter 3rd number: "
result: .asciiz "The sum is: "
	
.text
	
	#Input 1
	la $a0, n1
    	li $v0, 4
    	syscall
    	li $v0, 5
    	syscall
    	move $s0, $v0
    	
    	#Input 2
    	la $a0, n2
    	li $v0, 4
    	syscall
    	li $v0, 5
    	syscall
   	move $s1, $v0
   	
   	#Input 3
   	la $a0, n3
   	li $v0, 4
   	syscall
   	li $v0, 5
   	syscall
   	move $s2, $v0
   	
   	#Calculate result, Print result
    	la $a0, result
    	li $v0, 4
    	syscall
    	add $s3, $s0, $s1
    	add $s4, $s2, $s3
   	move $a0, $s4
    	li $v0, 1
    	syscall
    	
    	 #End
    	li $v0, 10
    	syscall
   	 
