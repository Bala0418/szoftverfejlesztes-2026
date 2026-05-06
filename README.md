# szoftverfejlesztes-2026

> Hallgatói projekt – UI automatizációs tesztek: **JUnit 5 + Cucumber + Spring + Selenium + Allure**

## 1. Mi ez a projekt?
Ez a projekt egy automatizált UI (felhasználói felület) teszt keretrendszer, amely a webes alkalmazások vizsgálatára készült.  
Konkrét célok:
- A főoldal megnyitása, a „Communities” gombra kattintás, és a közösségi kártyák ellenőrzése.
- A tesztek futtatása automatikusan, és látványos jelentések (Allure) generálása.
- Oktatási célra: bemutatja, hogyan lehet **Cucumber BDD** (Given‑When‑Then) stílusban írni teszteket, és hogyan lehet kombinálni JUnit 5, Spring DI, Selenium WebDriver‑t.

## 2. Mik az alapvető technológiák?
- **Java 23** – nyelvi fejlesztéshez.
- **Maven** – build és függőségkezelés.
- **JUnit 5** – teszt futtató keretrendszer.
- **Cucumber 7** – BDD típusú tesztekhez (feature fájlok + step definíciók).
- **Spring (Spring‑Test Context)** – dependency injection a tesztekben, Page Object model támogatás.
- **Selenium WebDriver + WebDriverManager** – böngésző automatizálás (pl. Chrome driver).
- **Allure Test Report** – vizuális, részletes tesztjelentések.

## 3. Projekt szerkezete
/src/test/java/deik/pti/config ← Spring konfigurációk (TestConfig, CucumberContextConfiguration)

/factory ← WebDriverFactory – böngésző példány kezelése

/pageObjects ← Page Object osztályok (HomePage, CommunitiesPage)

/stepdefinitions ← Cucumber lépések implementációi

/hooks ← @After, @Before hook‑ok (pl. képernyőkép, böngésző bezárás)

/src/test/resources

/features ← .feature fájlok (Cucumber)

pom.xml ← Maven konfiguráció

## 4. Első lépések – hogyan futtasd a projektet
### 4.1 Prerequisite (követelmények)
- Telepítve legyen Java 23 JDK és Maven a gépeden.
- Chrome böngésző (és az aktuális verzióhoz a WebDriverManager letölti a megfelelő drivert).
- (Opcionálisan) IntelliJ vagy más IDE könnyebb fejlesztéshez.

### 4.2 Projekt klónozása
```bash
git clone https://github.com/Bala0418/szoftverfejlesztes-2026.git
cd szoftverfejlesztes-2026
```
### 4.3 Tesztek futtatása
```bash
mvn clean test
```
Ez futtatja a Cucumber teszteket és létrehozza az Allure „results” mappát (target/allure-results).

### 4.4 Allure jelentés megtekintése
```bash
mvn allure:serve
```
Ez automatikusan elindít egy böngészőt és megnyitja az Allure jelentést.
Alternatíva:
```bash
mvn allure:report
```
majd nyisd meg a target/site/allure-maven/index.html fájlt.

# 5. Hasznos parancsok
Parancs	Magyarázat

```mvn clean test```	Tesztek futtatása minden build után.

```mvn allure:serve```	Allure jelentés megnyitása interaktívan.

```mvn allure:report```	Statikus jelentés generálása fájlba.

```git pull origin main --allow-unrelated-histories```	Ha már létező remote-hoz kapcsolod a projektet és külön története volt.

# 6. Hogyan bővítsd tovább?
Írj új .feature fájlokat más tesztesetekkel (pl. bejelentkezés, keresés, adatbevitel).

Készíts új Page Object osztályokat a weboldalad külön részeihez.

Bővíts hook‑okat: pl. böngésző előkészítés, adatok törlése, naplózás.

Integráld CI‑be (pl. GitHub Actions), hogy minden commit után automatikusan futjanak a tesztek és generálódjon a jelentés.

# 7. Mit tanulhatsz ebből?
Domain‑specifikus tesztek írása BDD módon („Given … When … Then …”).

Dependency Injection használata tesztekben Spring‑mel.

Oldal‑objektum minta (Page Object Model) a Selenium használatával.

Automatikus tesztjelentés generálása (Allure) — látványos vizuális output.

Git & GitHub alapjai: commit, push, pull, konfliktusok kezelése.

# 8. Licenc / Használat
Ez a projekt oktatási célra készült. Szabadon használható, módosítható a megfelelő jelzéssel.