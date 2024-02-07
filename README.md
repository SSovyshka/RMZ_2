# Розробка мобільних застосунків

# Практична робота №1.2 - Створення простого Android додатку

### Опис проекту
У цій практичній роботі створено простий Android додаток з однією кнопкою, яка змінює свій стиль та виконує певні дії при натисканні.

### Крок 1: Створення проекту
Проект створено з використанням API26 для Android 8 "Oreo". Встановлені відповідні налаштування для підтримки цієї версії Android.
<p>
  <img src="screenshots/1.png" width="600px">
</p>

### Крок 2: Налаштування інтерфейсу застосунку
Додано кнопку та вирівняно її по центру екрану. Змінено параметри кнопки в XML файлі для зміни її вигляду.
<p>
  <img src="screenshots/2.png" width="700px">
</p>

- В файлі ``` \app\src\main\res\layout\activity_main.xml ```, змінюю такі параметри
  
```java
android:id="@+id/click_me_button" -- Змінюю id об'єкту
android:layout_width="200dp" -- Змінюю ширину об'єкту
android:layout_height="53dp" -- Змінюю висоту об'єкту
android:text="Don't click me!" -- Змінюю текст об'єкту
tools:ignore="HardcodedText" -- Додаю параметр для ігнорування "хардкод-тексту"
```

<p>
  <img src="screenshots/3.png" width="1000px">
</p>

### Крок 3: Написання коду
Крок 3.1: Створення змінних
```java
private Button button; // Змінна для кнопки
private boolean styleFlag = false; // Змінна-перемикач для стилю кнопки
private boolean exitFlag = false; // Змінна для виходу з додатку
```

Крок 3.2: Метод `onCreate()`

```java
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    button = findViewById(R.id.click_me_button); // Находжу кнопку за заданим id раніше
    button.setOnClickListener(new View.OnClickListener() {
        // Встановлюємо слухач подій натискання на кнопку
        @Override
        public void onClick(View v) {
            // При натисканні на кнопку викликається метод handleButtonClick()
            handleButtonClick();
        }
    });
}
```

Крок 3.3: `Функція handleButtonClick()`
```java
private void handleButtonClick() {
    // Перевіряємо, чи встановлено прапорець стилю
    if (!styleFlag) {
        // Якщо встановлено прапорець виходу
        if (exitFlag) {
            showToast("Я з вами покінчив!", Toast.LENGTH_LONG);
            finish();  // Завершуємо активність (Activity)
        }

        // Встановлюємо стиль для кнопки
        setButtonStyle(button, Color.BLACK, Color.WHITE, "Більше не натискай на мене!");

        showToast("Привіт, чому ти на мене натискав?!", Toast.LENGTH_SHORT);
        styleFlag = !styleFlag;  // Змінюємо значення прапорця стилю
    }
    else {
        // Змінюємо стиль кнопки при іншому стані прапорця стилю
        setButtonStyle(button, Color.WHITE, Color.BLACK, "Чувак, ти не серйозний");

        styleFlag = !styleFlag;  // Змінюємо значення прапорця стилю
        exitFlag = !exitFlag;    // Змінюємо значення прапорця виходу
    }
}
```

Крок 3.4: Функція `setButtonStylae(Button, int, int, string)` та `showToast(String, int)`
```java
private void setButtonStyle(Button btn, int backgroundColor, int textColor, String buttonText) {
    btn.setBackgroundColor(backgroundColor); // Встановлюємо колір фону кнопки
    btn.setTextColor(textColor); // Встановлюємо колір тексту кнопки
    btn.setText(buttonText); // Встановлюємо текст кнопки
}
```
```java
private void showToast(String message, int duration) {
    Toast.makeText(this, message, duration).show(); // Створюємо і відображаємо повідомлення Toast з вказаним текстом і тривалістю
}
```

### Крок 4: Робочий додаток
Додаток працює як очікувано, змінюючи стиль кнопки та виводячи повідомлення при кожному натисканні.
<p>
  <img src="screenshots/4.gif" width="400px">
</p>

### Висновок
Практична робота демонструє базові кроки створення Android додатку з використанням Android Studio, включаючи налаштування інтерфейсу та написання коду для взаємодії з елементами інтерфейсу.
