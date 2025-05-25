Nino Mirevski 236073

<img width="1097" alt="Screenshot 2025-05-25 at 01 24 31" src="https://github.com/user-attachments/assets/ea5f6992-7062-4655-ac31-9967bb087578" />

Ciklomatskata kompleksnost e 9

TEST CASES 1:
allItems = null
cardNumber = "1234567812345678"

"allItems list can't be null!"

Ovoj test case e za:
if (allItems == null)

TEST CASES 2:
allItems = [new Item(null, 1, 100, 0.0)]
cardNumber = "1234567812345678"

"Invalid item!"

Ovoj test case e za:
if (item.getName() == null || item.getName().length() == 0)

TEST CASES 3:
allItems = [new Item("Book", 1, 100, 0.0)]
cardNumber = "12345678abcd5678"

"Invalid character in card number!"

Ovoj test case e za:
char[] chars

TEST CASES 4:
allItems = [new Item("Book", 1, 100, 0.0)]
cardNumber = "12345678"

"Invalid card number!"
Ovoj test case e za:
else

TEST CASES 5:
List<Item> items = Arrays.asList(
    new Item("Book", 5, 400, 0.2),  // triggers penalty + discount
    new Item("Notebook", 3, 200, 0.0)  // no penalty, no discount
);
checkCart(items, "1234567812345678")

Ovoj nema greska


Slucaj koga prviot e True
TXX checkCart(List.of(new Item("Nino", 0, 310, 0)), null) 
Slucaj koa prviot e False, a vtoriot True
FTX checkCart(List.of(new Item("Nino", 1, 100, 0.1)), null) 
Slucaj koga site se False
FFF checkCart(List.of(new Item("Nino", 1, 100, 0)), null) 
Slucaj koga samo posledniot e True
FFT checkCart(List.of(new Item("Nino", 11, 100, 0)), null

