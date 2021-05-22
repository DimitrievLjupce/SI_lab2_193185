# Втора лабораториска вежба по Софтверско инженерство
## Љупчо Димитриев, бр. индекс 193185

### 1. Control flow graph

![image](https://user-images.githubusercontent.com/79581166/119220936-22df3100-baed-11eb-98d6-e48e29ca143a.png)

### 2. Цикломатска комплексност

- Цикломатска комплексност на кодот изнесува 8, односно број на предикатни јазли + 1 = 7 + 1 = 8. Истата можеме да ја пресметаме и како број на ребра – број на јазли + 2, исто така и на трет начин со броење на регионите од графот.

### 3. Multiple conditions
If(h1<0 || hr>24) <br />
T X <br />
F T <br />
if (min < 0 || min > 59) <br />
T X  
F T  
F F  

else if (hr == 24 && min == 0 && sec == 0) <br />
T T T <br />
T T F <br />
T F X <br />
F X X <br />

@Test <br/>
    void multipleCondition()
    {    
        RuntimeException ex;  

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(-14, 27, 40))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(28, 32, 52))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        assertEquals(returnList(73550), SILab2.function(createList(new Time(20, 25, 50))));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(10, -22, 53))));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12, 64, 32))));
        assertTrue(ex.getMessage().contains("The minutes are not valid"));

        assertEquals(returnList(73550), SILab2.function(createList(new Time(20, 25, 50))));


        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(12, 45, 69))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(21, 42, -27))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));


        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24, 0, 10))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24, 14, 15))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

        assertEquals(returnList(73550), SILab2.function(createList(new Time(20, 25, 50))));
    }

### 4. Every branch testing
30 - 31  
31 - 31.1  
31.1 - 32  
31.1 - 50  
32 - 33  
33 - 34  
33 - 38  
34 - 35  
34 - 36  
36 - 37  
38 - 39  
39 - 40  
39 - 41  
41 - 42  
42 - 44  
42 - 43  
43 - 31.2  
44 - 45  
38 - 46  
46 - 47  
47 - 31.2  
46 - 48  
48 – 49  

@Test <br/>
    void everyBranch() {  
        RuntimeException ex;  

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(-2, 30, 50))));
        assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(25, 30, 50))));
        assertTrue(ex.getMessage().contains("The hours are grater than the maximum"));

        //The minutes are not valid!
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(23, -2, 50))));
        assertTrue(ex.getMessage().contains("The minutes are not valid!"));
        //The seconds are not valid
        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(23, 2, 61))));
        assertTrue(ex.getMessage().contains("The seconds are not valid"));

        ex = assertThrows(RuntimeException.class, () -> SILab2.function(createList(new Time(24, 61, 61))));
        assertTrue(ex.getMessage().contains("The time is greater than the maximum"));

	List<Time> empty = new ArrayList<Time>(0);
        assertEquals(empty, SILab2.function(empty));

        assertEquals(returnList(73550), SILab2.function(createList(new Time(20, 25, 50))));
        assertEquals(returnList(86400), SILab2.function(createList(new Time(24, 0, 0))));
        
    }

### Тест случаи според критериумот - MultipleCondition  
Со овие тестови соодветно правиме тестирање на повеќе од еден услов. Исто и овде искористив AssertThrows, AssertTrue, AssertEquals соодветно според кодот за да направам споредување, за да биде фатен соодветниот exception и слично.  

### Тест случаи според критериумот - EveryBranch  

Сите тестирања ги напишав на сличен начин со што истите може да се погледнат во кодот кој го приложувам исто така. Кратко објаснување за следниве тестови е тоа што искористувам AssertTrue и AssertThrows. Соодветно со AssertThrows очекувам да биде фатен одреден exception и проверувам дали е фрлен точниот exception со соодветно проверување на самата порака со методот AssertTrue пример:  

assertTrue(ex.getMessage().contains("The hours are smaller than the minimum"));   

Тестот овде би поминал доколку пораката која ја добивам од exception-oт е иста со пораката која ја имам ставено соодветно во самиот тест.


