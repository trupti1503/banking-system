# 🏦 Console-Based Banking System

A comprehensive Java application that simulates a real-world banking system with multiple accounts, deposits, withdrawals, and daily withdrawal limits.

## 📋 Table of Contents

- [Features](#features)
- [Project Structure](#project-structure)
- [Classes Overview](#classes-overview)
- [Usage](#usage)
- [Key OOP Principles](#key-oop-principles)
- [Input Validation & Exception Handling](#input-validation--exception-handling)
- [Daily Withdrawal Limit](#daily-withdrawal-limit)
- [How to Run](#how-to-run)

---

## ✨ Features

✅ **Create Multiple Accounts** - Generate unique accounts for different users  
✅ **Deposit Money** - Add funds to any account  
✅ **Withdraw Money** - Withdraw with daily limit enforcement  
✅ **Check Balance** - View current account balance  
✅ **View Account Information** - Display complete account details  
✅ **Daily Withdrawal Limit** - Prevent excessive withdrawals (default: $5000/day)  
✅ **Menu-Driven Interface** - User-friendly console navigation  
✅ **Multiple Accounts Management** - Store and manage many accounts  
✅ **Encapsulation** - Secure data with private fields  
✅ **Robust Exception Handling** - Validates all user inputs  
✅ **Date-Based Tracking** - Automatically resets daily limits each day

---

## 🏗️ Project Structure

```
banking-system/
├── Account.java
├── Bank.java
├── BankingApp.java
└── README.md
```

---

## 📚 Classes Overview

### 1. **Account.java**
Represents an individual bank account with the following responsibilities:

**Attributes:**
- `accountHolderName` - Name of account owner  
- `accountNumber` - Unique account identifier  
- `balance` - Current account balance  
- `dailyWithdrawalLimit` - Maximum withdrawal per day  
- `dailyWithdrawals` - Map to track withdrawals by date

**Methods:**
- `deposit(double amount)` - Add money to account  
- `withdraw(double amount)` - Withdraw money with limit validation  
- `getBalance()` - Return current balance  
- `getAccountHolderName()` - Return account holder name  
- `getAccountNumber()` - Return unique account number  
- `getDailyWithdrawalLimit()` - Return withdrawal limit  
- `getWithdrawnToday()` - Return amount withdrawn today  
- `displayAccountInfo()` - Show formatted account details

### 2. **Bank.java**
Manages all accounts in the banking system.

**Attributes:**
- `accounts` - ArrayList of Account objects  
- `DEFAULT_DAILY_WITHDRAWAL_LIMIT` - Default limit ($5000)

**Methods:**
- `createAccount(String name, double balance)` - Create new account  
- `findAccount(String accountNumber)` - Search for account by number  
- `getAllAccounts()` - Return list of all accounts  
- `generateAccountNumber()` - Create unique account number  
- `displayAllAccounts()` - Show summary of all accounts

### 3. **BankingApp.java**
Console-based user interface with menu system.

**Methods:**
- `run()` - Start the application  
- `showMainMenu()` - Display main menu options  
- `showAccountMenu(Account)` - Display account operations menu  
- `createNewAccount()` - Handle account creation  
- `accessExistingAccount()` - Access existing account  
- `accountOperations(Account)` - Handle account operations  
- `depositMoney(Account)` - Process deposits  
- `withdrawMoney(Account)` - Process withdrawals  
- `checkBalance(Account)` - Display balance info  
- `getValidAmount()` - Validate monetary input  
- `getValidChoice()` - Validate menu choice

---

## 🎮 Usage

### Main Menu Options

```
1. Create New Account
   - Enter account holder name
   - Enter initial deposit amount
   - System generates unique account number

2. Access Existing Account
   - Enter account number
   - Access account operations menu

3. View All Accounts
   - See summary of all accounts in the bank

4. Exit
   - Close the application
```

### Account Operations Menu

```
1. Deposit Money
   - Enter deposit amount
   - Balance updated instantly

2. Withdraw Money
   - Enter withdrawal amount
   - Checked against balance and daily limit

3. Check Balance
   - View current balance and withdrawal limits

4. Display Account Information
   - See detailed account summary

5. Back to Main Menu
   - Return to main menu
```

---

## 🏛️ Key OOP Principles

### 1. **Encapsulation**
- All account data is private  
- Controlled access through public methods  
- Protects data integrity

```java
private String accountHolderName;
private double balance;
// Public getter/setter methods
```

### 2. **Abstraction**
- Complex daily withdrawal logic hidden in Account class  
- Users interact with simple methods  
- Internal implementation details concealed

### 3. **Collections**
- `ArrayList<Account>` manages multiple accounts  
- Dynamic account management  
- Scalable design

### 4. **Input Validation**
- All inputs validated before processing  
- Appropriate error messages  
- Exception handling for edge cases

---

## ✅ Input Validation & Exception Handling

**Account Creation:**
- Name cannot be empty  
- Initial balance cannot be negative  
- Generates unique account number

**Deposit:**
- Amount must be greater than zero  
- Only positive values accepted  
- Balance updated securely

**Withdrawal:**
- Amount must be greater than zero  
- Amount cannot exceed balance  
- Daily limit validation  
- Clear error messages with remaining limits

**Account Access:**
- Account number validated  
- Appropriate error if account not found

---

## 💰 Daily Withdrawal Limit

**Default Limit:** $5000 per day

**How It Works:**
1. System tracks withdrawals by date using `HashMap<LocalDate, Double>`  
2. Each day the limit resets automatically  
3. Users see:
   - Amount withdrawn today
   - Remaining limit for the day
   - Clear error if limit exceeded

**Example:**
```
Daily Limit: $5000.00
Withdrawn Today: $2000.00
Remaining Limit: $3000.00
```

---

## 🚀 How to Run

### Prerequisites
- Java 8 or higher  
- Compiler: `javac`

### Compilation
```bash
# Compile all files
javac banking/Account.java
javac banking/Bank.java
javac banking/BankingApp.java

# Or compile all at once
javac banking/*.java
```

### Execution
```bash
java banking.BankingApp
```

### Sample Interaction
```
★★★★★★★★★★★★★★★★★★★★★★★★★★★★
   Welcome to Banking System
★★★★★★★★★★★★★★★★★★★★★★★★★★★★

============================================================
           ★ WELCOME TO BANKING SYSTEM ★
============================================================
1. Create New Account
2. Access Existing Account
3. View All Accounts
4. Exit
============================================================
Select an option (1-4): 1

============================================================
                    CREATE NEW ACCOUNT
============================================================
Enter account holder name: John Doe
Enter initial balance: $5000

✓ Account created successfully!
Account Number: ACC1701512345678123
Account Holder: John Doe
Initial Balance: $5000.00
```

---

## 🔐 Security Features

- **Encapsulation**: Private fields protect data  
- **Validation**: All inputs checked before processing  
- **Exception Handling**: Graceful error management  
- **Daily Limits**: Prevents excessive withdrawals  
- **Unique Account Numbers**: Prevents account confusion  
- **Date Tracking**: Automatic daily limit reset

---

## 📝 Example Scenarios

### Scenario 1: Create Account and Deposit
```
1. Create account for "Alice" with $1000 initial balance
2. Deposit $500
   Result: Balance = $1500
```

### Scenario 2: Exceed Daily Limit
```
1. Account balance: $10000
2. Daily limit: $5000
3. Try to withdraw $6000
   Result: Error - exceeds daily limit
           Can withdraw max: $5000
```

### Scenario 3: Insufficient Balance
```
1. Account balance: $2000
2. Try to withdraw $3000
   Result: Error - insufficient balance
           Available: $2000
```

---

## 🎯 Educational Value

This project demonstrates:
- **OOP Principles**: Encapsulation, abstraction, and collections  
- **Exception Handling**: Try-catch blocks and custom validation  
- **Data Structures**: HashMap for date-based tracking, ArrayList for account management  
- **User Interface**: Menu-driven console application  
- **Real-world Scenario**: Banking system simulation

---

## 📞 Support

For issues or questions:
1. Review the code comments  
2. Check the error messages for guidance  
3. Verify input format matches requirements

---

## 📄 License

This project is open source and available under the MIT License.

---

**Created:** 2026-04-05  
**Last Updated:** 2026-04-05