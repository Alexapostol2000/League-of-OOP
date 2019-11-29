Apostol Vasile-Alexandru
Grupa : 324CD

	=======================================	
=======	Proiect - Etapa 1 - League of OOP========
	=======================================

->Main function:
*Se citesc datele de intrare si se creaza un nou set de date de intrare 
cu ajutorul claselor GameInput si GameInputLoader.
*Se creaza harta cu ajutorul clasei map ,  se creeaza playerii , 
carora li se atribuie atat rasa cat si pozitia pe harta inainte ca meciul sa inceapa;
*Se parcurg toate rundele , iar cu ajutorul clasei Game se apeleaza 2 metode 
MovePlayer si Fight care fac gameplaye-ul jocului propriu-zis;
*La sfarsit se afiseaza rezultatul jocului in formatul specificat;

->Game/GameInput:
*Am ales sa folosesc clasele astea pe care le-am primit in scheletul din prima tema , 
adaptate pentru datele mele de intarare;

->Map:
*Primeste tipurile de terenuri aloca o matrice de char pe care o populeaza cu 
tipurile de teren din acele pozitii. La sfarsit returneaza matricea;
 
->Game:
*moveplayers - Muta playerii in functie de directia pe care acestia o doresc.
*fight - intereaza prin toate perechile posibile de jucatori , in momentul 
in care gaseste 2 jucatori pe aceeasi pozitie verifica daca acestia sunt vi ,
aplica damage-ul de la ignite sau paralysis daca  playerul are activate aceste abilitati asupra sa. 
In funtie de ce tip de player este calculeaza damage-ul dat de acesta asupra celuilalt , 
la sfarsit aplica damage-ul si verifica daca vreun player a facut kill , 
in caz afirmativ acesta primeste xp corespunazator , iar apoi apeleaza levelup.

->Player 
*clasa abstracta din care se extind celelalte rase;

->Knight
*contine abilitatile execute si slam , acesteaza returneaza damage-ul dat in functi de victima 
iar metoda calclatedamage calculeaza damage-ul dat de ambele . 
Abilitatea slam activeaza campul de  stan(incapacitatea de miscare) adversarului o runda;
*contine si metoda suprascisa levelup cu rolul de a face levelup playerului 
si a-i reda hp inapoi in momentul in care acesta face level up;

->Pyromancer:
*contine abilitatile ignite si fireblast , care calculeaza si returneaza damege-ul dat ,  
abilitatea ignite seteaza si campul isignite al playerului atacat pentru ca acesta 
sa primeasca damage si rundele urmatoare;
*contine si metoda suprascisa levelup cu rolul de a face levelup playerului 
si a-i reda hp inapoi in momentul in care acesta face level up;

->Rogue:
*contine abilitatile backstab si paralysis, care calculeaza si returneaza damege-ul dat. 
Abilitatea paralysis paralizeaza adversarul (incapacitate de miscare) 
pentru un anume numar de runde in functie de terenul pe care se afla;
*contine si metoda suprascisa levelup cu rolul de a face levelup playerului 
si a-i reda hp inapoi in momentul in care acesta face level up;

->Wizard:
*contine abilitatile drain si deflact , calculeaza si returneaza damage-ul dat. 
Abilitatea drain se foloseste de damage-ul suferit de player in fuctie de care da damage. 
In cazul in care victima e tot Wizard abilitatea are efect nul;
*contine si metoda suprascisa levelup cu rolul de a face levelup playerului 
si a-i reda hp inapoi in momentul in care acesta face level up;

 