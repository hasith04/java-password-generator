# Password Generator

A Java console application that generates random passwords and evaluates password strength.

## Features

- Generate a strong random password using one or more of the following character sets:
  - uppercase letters
  - lowercase letters
  - numbers
  - symbols
- Check password strength using character variety and length.
- Display password security guidance.

## Usage

1. Run `Main`.
2. Choose `1` to generate a password, `2` to check a password, `3` to view guidance, or `4` to quit.
3. For password generation, answer prompts with `Yes` or `No` and supply a length.

## Notes

- Passwords are generated with `SecureRandom`.
- Strength is scored by use of uppercase, lowercase, numbers, symbols, and length thresholds.
- The application validates input and requests corrections when needed.
