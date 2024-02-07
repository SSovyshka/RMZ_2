# Розробка мобільних застосунків

# Практична робота №1.3 - Робота із активностями в ОС Android.

### Опис проекту
Отримати досвід роботи із процесамм відстеження станів активності.

### Крок 1: Додавання коду до попереднього проекту.
Перероблюю функцію ```handleButtonClick()```.
```java
private void handleButtonClick(){
    if(clickCounter == 0){
        setButtonStyle(button, Color.BLACK, Color.WHITE, "Don't click on me anymore!");
        showToast("Hey, why you clicked me?!", Toast.LENGTH_SHORT);
        hackWriter.setVisibility(View.GONE);
        clickCounter++;

    }else if(clickCounter == 1){
        setButtonStyle(button, Color.WHITE, Color.BLACK, "Dude, you're not serious");
        clickCounter++;
    }else if(clickCounter == 2){
        showToast("I'm done with you!", Toast.LENGTH_LONG);
        finish();
    }
}
```
Додаю метод ```onStart()```
```java
@Override
protected void onStart() {
    super.onStart();

    hackWriter = findViewById(R.id.hackWriter);
    int randomIndex = (int) (Math.random() * joke.length);

    hackWriter.setText(joke[randomIndex]);

    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            handleButtonClick();
        }
    });
}
```
Додаю метод ```onPause()```
```java
@Override
protected void onPause() {
    super.onPause();
    showToast("Shut me down!", Toast.LENGTH_SHORT);
}
```

Додаю метод ```onRestart()```
```java
@Override
protected void onRestart() {
    super.onRestart();
    if (clickCounter > 0) {
        setButtonStyle(button, Color.BLACK, Color.WHITE, "Why did you come back?");
        hackWriter.setVisibility(View.GONE);
        clickCounter = 0;
    }
}
```



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
