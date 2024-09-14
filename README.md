Imię i nazwisko: Magdalena Kubacka
Nazwa: Sklep z roślinami
Opis: Jest to aplikacja do zamawiania roślin w sklepie internetowym.
(HTML + CSS, Thymeleaf ):
- przeglądanie strony internetowej z roślinami, dodawanie do koszyka zamówienia (resources.templates.home.html);
-przejście na panel z dokonywaniem modyfikacji w zamówieniu: usuwanie przedmiotów, dodawanie ilości, podsumowanie kwoty do zapłaty i przejście dalej do finalizacji zamówienia (resources.templates.cartView.html);
- finalizacja zamówienia, wpisywanie danych potrzebnych do wysyłki i przesłanie zamówienia do bazy danych H2(resources.templates.summary.html);
  
-możliwość dodawania nowych przedmiotów do asortymentu(resources.templates.adminview.addItem.html);

Java, Spring Framework, Maven:
Część związana z kodowaniem operacji przeprowadzanych w aplikacji.Tworzenie serwisów, kontrolerów, danych potrzebnych do dodawania przedmiotów do bazy danych, jak i przeprowadzania operacji związanych z zawartością sklepu oraz dokonywaniem zamówienia. 

Baza danych H2:
Przechowywanie danych związanych z działalnością sklepu (asortyment, zamówienia, które wpłynęły) Możliwość modyfikacji danych.
