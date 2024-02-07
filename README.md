# Розробка мобільних застосунків

# Практична робота №1.3 - Робота із активностями в ОС Android.

### Опис проекту
Отримати досвід роботи із процесамм відстеження станів активності.

### Крок 1: Додавання коду до попереднього проекту.
Крок 1.1: Перероблюю функцію ```handleButtonClick()```.
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
Крок 1.2: Додаю метод ```onStart()```
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
Крок 1.3: Додаю метод ```onPause()```
```java
@Override
protected void onPause() {
    super.onPause();
    showToast("Shut me down!", Toast.LENGTH_SHORT);
}
```

Крок 1.4: Додаю метод ```onRestart()```
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

### Крок 2: Додавання TextView
-В файлі \app\src\main\res\layout\activity_main.xml, додаю новый View

```
<TextView
    android:id="@+id/hackWriter"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_marginTop="24dp"
    android:text=""
    app:layout_constraintEnd_toEndOf="parent"
    app:layout_constraintStart_toStartOf="parent"
    app:layout_constraintTop_toTopOf="parent" />
```


### Крок 3: Робочий додаток
Додаток працює як очікувано, змінюючи стиль кнопки при паузі додатку.

https://github.com/SSovyshka/RMZ_2/assets/91850335/6ecd9957-9daf-4fb1-b81a-bce1aa624063




### Висновок
Практична робота демонструє базові кроки створення Android додатку з використанням Android Studio, включаючи налаштування інтерфейсу та написання коду для взаємодії з елементами інтерфейсу.
