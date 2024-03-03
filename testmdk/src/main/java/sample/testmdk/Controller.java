package sample.testmdk;

import java.net.URL;
import java.util.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Label question;


    @FXML
    private AnchorPane questionscene;

    @FXML
    private RadioButton radio_button1;

    @FXML
    private RadioButton radio_button2;

    @FXML
    private RadioButton radio_button3;

    @FXML
    private RadioButton radio_button4;

    @FXML
    private ToggleGroup radiobutton;

    @FXML
    private Button startbutton;
    @FXML
    private Button answerbutton;


    private final Questions[] questions = new Questions[]{
            new Questions("Переменная int?", new String[] { "символьная", "логическая", "вещественная", "целая "}, "целая "),
            new Questions("Переменная float?", new String[]{"символьная строка","логическая переменная", "целая переменная", "вещественная переменная"}, "вещественная переменная"),
            new Questions("Переменная str?", new String[] {"логическая переменная", "целая переменная", "вещественная переменная","символьная строка"}, "символьная строка"),
            new Questions("Переменная bool?", new String[] {"вещественная переменная","символьная строка","логическая переменная","целая переменная"},"логическая переменная"),
            new Questions("Каково основное назначение рекурсивной функции?", new String[] {"Замена цикла","Работа со списками","Врзращение необходимого результата","Итерационный перебор через циклы"},"Замена цикла"),
            new Questions("Какое зарезервированное слово применяется для определения функции в Pyhton?", new String[] {"Define","Procedure","Func","Def"},"Def"),
            new Questions("Чем являются функции в Python?", new String[] {"Экземплярами","Классами","Методами","Объектами"},"Объектами"),
            new Questions("Что такое рекурсия?", new String[] {"Вызов функции в обратном порядке ее алгоритма","Возвращение результатов функции","Подбор параметров функции","Описание какого-либо объекта внутри этого самого"},"Описание какого-либо объекта внутри этого самого"),
            new Questions("Сколько библиотек можно импортировать в один проект?", new String[] {"Не более 10","Более 5","Не более 23","Неограниченное количество"},"Неограниченное количество"),
            new Questions("Что будет показано в результате? Name = Max\n Print('Hi, %s' % name)", new String[] {"«Hi, «","Ошибка","«Hi, Max»","«Hi, name»"},"«Hi, Max»"),
            new Questions("Какая функция выводит что-либо в консоль?", new String[] {"Print()","Write()","Log()","Out()"},"Print()"),
            new Questions("Как вывести список методов и атрибутов объекта x?", new String[] {"Help(x)","Info(x)","?x","Dir(x)"},"Dir(x)"),
            new Questions("С помощью Python нужно записать данные в файл, но только в том случае, если файла ещё нет. Какой режим указать в инструкции open()?", new String[] {"x","Никакой","w","r"},"x"),
            new Questions("Как получить данные от пользователя?", new String[] {"readline()","cin()","input()","read()"},"input()"),
            new Questions("Где правильно создана переменная?", new String[] {"num = float (2)","int num = 2","var num = 2","$num = float (2)"},"num = float (2)"),
            new Questions("Какие типы переменных существуют?", new String[] {"int, char, bool, float, double","int, char, bool, string","Нет верного ответа","Оба варианта верны"},"Оба варианта верны"),
            new Questions("Какая библиотека отвечает за время?", new String[] {"time","local Time","clock","нет правильного ответа"},"time"),
            new Questions("Необходимо собрать и вывести все уникальные слова из строки рекламного текста. Какой из перечисленных типов данных Python подходит лучше всего?", new String[] {"кортеж (tuple)","список (list)","словарь (dict)","множество (set)"},"словарь (dict)"),
            new Questions("Какая из перечисленных инструкций выполняется быстрее всего, если n = 10 **6?", new String[] {"null","a = (i for i in range (n))","a = (i for i in range (n-n))","a = list(i for i in range (n))"},"a = (i for i in range (n))+"),
            new Questions("Как сделать декрементацию числа?", new String[] {"!=","dec","-=","%%"},"-="),
            new Questions("Как сделать инкрементацию числа?", new String[] {"+=","!=","inc","-"},"+="),
            new Questions("Язык программирования Python подходит для разработки:", new String[] {"Компьютерных и мобильных приложений","Машинное обучение","Ничего из этого","Оба ответа верны"},"+="),
            new Questions("Что хранит в себе переменная?", new String[] {"Имя","Значение","Тип","Длину"},"Значение"),
            new Questions("Выберите правильную запись оператора присваивания", new String[] {"10 = х","у = 7,8","a = 5","a == b + x"},"10 = х"),
            new Questions("Сколько возможных значений у переменной типа bool?", new String[] {"1","0","4","2"},"2"),
            new Questions("Что лучше использовать для множественного ветвления?", new String[] {"if – elif –else","Много if","if-else-elif","while"},"if – elif –else"),
            new Questions("Оператор цикла в языке Python?", new String[] {"while","if","print","hiik"},"while"),
            new Questions("Для чего нужен оператор break?", new String[] {"Для завершения цикла","Для выхода из программы","Для краша системы","Для удаления программы"},"Для завершения цикла"),
            new Questions("Что делает функция len()?", new String[] {"Возращает длину строки","Возращает случайное число","Возращает дату","Возращает модуль числа"},"Возращает длину строки"),
            new Questions("Как добавить модуль в программу?", new String[] {"import math","import math()","import (math)","import.math"},"import math"),
            new Questions("а = 345. Что выведет команда print(//100)?", new String[] {"3","5","7","none"},"3"),
            new Questions("Что такое else?", new String[] {"иначе","так как","если","потому что"},"иначе"),
    };
    private int nowQuestion = 0, correctAnswers;
    private String nowCorrectAnswer;

/*
    @FXML
    void initialize(ActionEvent event) {

    }
*/

    @FXML
    public void initialize() {
        //Создаем лист из 10 случайных вопросов, генерируемых с массива вопросов
        List<Integer> randomIndexes = new ArrayList<>();
        Random random = new Random();
        while (randomIndexes.size() < 10) {
            int index = random.nextInt(questions.length);
            if (!randomIndexes.contains(index)) {
                randomIndexes.add(index);
            }
        }
        //Скрыл сцену с вопросами
        questionscene.setVisible(false);
        //Нажали на кнопку Начать и появляются вопросы
        startbutton.setOnAction(actionEvent -> {
            startbutton.setVisible(false);
            questionscene.setVisible(true);
            nowQuestion = 0; // Сброс текущего вопроса
            question.setText(questions[randomIndexes.get(nowQuestion)].getQuestion());
            String[] answers = questions[randomIndexes.get(nowQuestion)].getAnswers();
            List<String> stringList = Arrays.asList(answers);
            Collections.shuffle(stringList);
            radio_button1.setText(stringList.get(0));
            radio_button2.setText(stringList.get(1));
            radio_button3.setText(stringList.get(2));
            radio_button4.setText(stringList.get(3));
        });
        //Нажали на кнопку Ответить
        answerbutton.setOnAction(actionEvent -> {
            //Получил ответ от пользователя
            RadioButton radioButton = (RadioButton) radiobutton.getSelectedToggle();
            if (radioButton != null) {
                String selectedAnswer = radioButton.getText();
                String correctAnswer = questions[randomIndexes.get(nowQuestion)].getCorrectAnswer();
                //Если вопросы еще есть, то добавляю их случайным образом и заполняю вопрос и 4 ответа к нему
                if (selectedAnswer.equals(correctAnswer)) {
                    correctAnswers++;
                }

                if (nowQuestion < randomIndexes.size() - 1) {
                    nowQuestion++;
                    question.setText(questions[randomIndexes.get(nowQuestion)].getQuestion());
                    String[] answers = questions[randomIndexes.get(nowQuestion)].getAnswers();

                    List<String> stringList = Arrays.asList(answers);
                    Collections.shuffle(stringList);

                    radio_button1.setText(stringList.get(0));
                    radio_button2.setText(stringList.get(1));
                    radio_button3.setText(stringList.get(2));
                    radio_button4.setText(stringList.get(3));
                } else {//Когда вопросы закончились скрываю кнопки и вывожу информацию о завершении теста
                    radio_button1.setVisible(false);
                    radio_button2.setVisible(false);
                    radio_button3.setVisible(false);
                    radio_button4.setVisible(false);
                    answerbutton.setVisible(false);
                    startbutton.setVisible(false);
                    question.setText("Тест завершен. Вы ответили корректно на " + correctAnswers + " из " + randomIndexes.size() + " вопросов");
                }
            }

        });
    }
}