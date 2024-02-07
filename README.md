# Розробка мобільних застосунків

# Практична робота №1.3 - Робота із активностями в ОС Android.

### Опис проекту
Отримати досвід роботи із процесамм відстеження станів активності.

### Крок 1: Додавання коду до попереднього проекту.
Крок 1.1: Перероблюю функцію ```handleButtonClick()```.
```java
private void handleButtonClick(){
    // Перевірка значення clickCounter для визначення подальших дій
    if(clickCounter == 0){
        // Якщо це перше натискання, змінити стиль кнопки, показати повідомлення toast, приховати hackWriter та збільшити clickCounter
        setButtonStyle(button, Color.BLACK, Color.WHITE, "Не натискайте більше на мене!");
        showToast("Привіт, чому ти натиснув на мене?!", Toast.LENGTH_SHORT);
        hackWriter.setVisibility(View.GONE);
        clickCounter++;

    }else if(clickCounter == 1){
        // Якщо це друге натискання, змінити стиль кнопки та збільшити clickCounter
        setButtonStyle(button, Color.WHITE, Color.BLACK, "Ти серйозно?");
        clickCounter++;
    }else if(clickCounter == 2){
        // Якщо це третє натискання, показати довге повідомлення toast та завершити діяльність
        showToast("Я з вами закінчив!", Toast.LENGTH_LONG);
        finish();
    }
}
```
Крок 1.2: Додаю метод ```onStart()```
```java
@Override
protected void onStart() {
    super.onStart();

    // Знаходження елементу TextView за його ідентифікатором
    hackWriter = findViewById(R.id.hackWriter);
    
    // Генерування випадкового індексу для вибору жарту з масиву
    int randomIndex = (int) (Math.random() * joke.length);

    // Встановлення тексту у hackWriter з випадковим жартом(там немає жартів)
    hackWriter.setText(joke[randomIndex]);

    // Налаштування обробника кліків кнопки
    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            // Виклик методу handleButtonClick() при кліку на кнопку
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
    
    // Показ короткого повідомлення toast при виклику onPause()
    showToast("Закрийте мене!", Toast.LENGTH_SHORT);
}
```

Крок 1.4: Додаю метод ```onRestart()```
```java
@Override
protected void onRestart() {
    super.onRestart();
    
    // Перевірка, чи були зроблені натискання на кнопку перед виходом з активності
    if (clickCounter > 0) {
        // Якщо так, змінити стиль кнопки, приховати TextView і скинути лічильник натискань
        setButtonStyle(button, Color.BLACK, Color.WHITE, "Чому ти повернувся?");
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
Практична робота демонструє базові кроки взаємодії зі станами з використанням Android Studio.
