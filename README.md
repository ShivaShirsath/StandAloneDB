# Swing DB

<details>
  <summary>
    SetUp
  </summary>

+ FrontEnd
  - Java AWT
  - Javax Swing
+ Logic
  - Java
+ BackEnd
  - SQL
  - SQLite
  - mySQL

+ SQLite Driver
  - [github](https://github.com/xerial/sqlite-jdbc)
  - [Download](https://github.com/xerial/sqlite-jdbc/releases/download/3.36.0.3/sqlite-jdbc-3.36.0.3.jar)
  
  - Bash Cammand
    ```bash
      sudo apt install -y wget && cd StandAloneDB && wget https://github.com/xerial/sqlite-jdbc/releases/download/3.36.0.3/sqlite-jdbc-3.36.0.3.jar
    ```
  
</details>

<details>
  <summary>
    Run
  </summary>

```bash
  VERSION = 3.36.0.3
  rm -rf *.class && javac *.java && java -classpath .:sqlite-jdbc-${VERSION}.jar Main
```

</details>

