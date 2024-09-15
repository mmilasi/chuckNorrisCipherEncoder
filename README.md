# Chuck Norris Cipher Encoder


1) descrizione in 🇮🇹
2) description in 🇺🇸

# Introduzione 🇮🇹
Questo programma Java implementa un sistema di codifica e decodifica basato sul cifrario "Chuck Norris", un sistema di codifica unario. Consente all'utente di codificare una stringa in formato unario o di decodificare una stringa unaria codificata nel formato testuale originale.

# Funzionalità
- Encode: Converte una stringa nel suo formato Chuck Norris codificato.
- Decode: Decodifica una stringa Chuck Norris codificata per riportarla al testo originale.
- Exit: Termina il programma.

# Utilizzo
Il programma chiede continuamente un'operazione (encode, decode, exit) ed esegue l'azione corrispondente. Se l'input non è valido, avviserà l'utente.
# Esempio di Utilizzo:
```
Please input operation (encode/decode/exit):
> encode
Input string:
> Hello
Encoded string:
0 0 00 0000 0 00 00 00 0 0 00 0 0 000 00 0000 0 00 00 00 0 00 00 00 0 0

Please input operation (encode/decode/exit):
> decode
Input encoded string:
> 0 0 00 0000 0 00 00 00 0 0 00 0 0 000 00 0000 0 00 00 00 0 00 00 00 0 0
Decoded string:
Hello

Please input operation (encode/decode/exit):
> exit
Bye!
```

# Gestione degli Input Non Validi
Se viene inserita un'operazione non valida, il programma risponderà con:
```
There is no '<operation>' operation
```

Se viene inserita una stringa codificata non valida, il programma risponderà con:
```
Encoded string is not valid.
```

# Come Funziona
- Codifica: La stringa di input viene convertita in una stringa binaria (7 bit per carattere) e poi codificata utilizzando il cifrario unario Chuck Norris.
  Ad esempio, la stringa Hello diventa 0 0 00 0000 0 00 00 00 0 0 00 0 0 000 00 0000 0 00 00 00 0 00 00 00 0 0.
- Decodifica: La stringa codificata viene analizzata, validata e convertita nuovamente in binario e quindi nel suo formato testuale originale.


# Introduction 🇺🇸
This Java program implements an encoding and decoding system based on the "Chuck Norris" cipher, a unary encoding system. It allows the user to encode a string into a unary format or decode an encoded unary string back to its original text form.

# Features
- Encode: Converts a string into its Chuck Norris encoded format.
- Decode: Decodes a Chuck Norris encoded string back into the original text.
- Exit: Terminates the program.

# Usage
The program continuously asks for an operation (encode, decode, exit) and performs the corresponding action. If the input is invalid, it will notify the user.
# Example Usage:
```
Please input operation (encode/decode/exit):
> encode
Input string:
> Hello
Encoded string:
0 0 00 0000 0 00 00 00 0 0 00 0 0 000 00 0000 0 00 00 00 0 00 00 00 0 0

Please input operation (encode/decode/exit):
> decode
Input encoded string:
> 0 0 00 0000 0 00 00 00 0 0 00 0 0 000 00 0000 0 00 00 00 0 00 00 00 0 0
Decoded string:
Hello

Please input operation (encode/decode/exit):
> exit
Bye!
```

# Invalid Input Handling
If an invalid operation is entered, the program will respond with:
```
There is no '<operation>' operation
```
If an invalid encoded string is entered, the program will respond with:
```
Encoded string is not valid.
```

# How It Works
- Encoding: The input string is converted to a binary string (7 bits per character) and then encoded using Chuck Norris' unary cipher.
  For example, the string Hello becomes 0 0 00 0000 0 00 00 00 0 0 00 0 0 000 00 0000 0 00 00 00 0 00 00 00 0 0.
- Decoding: The encoded string is parsed, validated, and converted back to binary and then to its original string format.
