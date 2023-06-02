<h1 style="text-align: center;">Компьютерный магазин</h1>
<hr>


###Установка приложения на компьютер
1. Скопируйте ссылку на репозиторий GitHub.
2. В среде разработки (при создании и проверке использовалась IntellijIdea Ultimate) выберите File -> New -> Project from Version Control. Вставьте ссылку и нажмите Clone.
3. Дождитесь установки приложения.

###Запуск программы
При запуске может появиться окно "Enable annotation processing", связанное с использованием Lombook. Рекомендуется нажать кнопку Enable. 

Затем откройте Postman или другой аналогичный сервис. 

###Проверка запросов
<b>1. Добавление товара. <br></b>
1) В строке запроса введите http://localhost:8080/test/products/add_product.
2) Выберите метод запроса <b>POST</b>.
3) На вкладке Body выберите "raw", а в выпадающем меню - Json. 
4) Скопируйте один из следующих компонентов в поле ввода тела запроса. 
Ниже приведенные данные соответствуют Компьютеру, Монитору, Жесткому Диску и Ноутбуку соответственно. 
<pre>
{
    "serialNumber": 1,
    "manufacturer": "Asus", 
    "price": 14.38,
    "count": 35,
    "formFactor": "DESKTOP"
}
</pre>
<pre>
{
    "serialNumber": 2,
    "manufacturer": "LG", 
    "price": 55,
    "count": 55,
    "diagonal": 14
}</pre>
<pre>
{
    "serialNumber": 3,
    "manufacturer": "Toshiba", 
    "price": 18.5,
    "count": 1,
    "volume": "8"
}</pre>
<pre>
{
    "serialNumber": 4,
    "manufacturer": "MSI", 
    "price": 78.1,
    "count": 10,
    "size": "SMALL"
}
</pre>
После ввода данных нажмите "Send". Если операция проведена успешно, в поле ответа появится созданный объект (аналогично для следующих пунктов).
<br><br><b>2. Редактирование товара. <br></b>
1) В адресной строке введите http://localhost:8080/test/products/edit/1, где "1" - идентификатор объекта, который нужно редактировать.
2) Выберите тип запроса <b>PUT</b>.
3) Измените уже введенные в первом пункте данные и отправьте запрос. 

Обратите внимание, что параметры "formFactor" и "size" - перечисления, поэтому они могут иметь только конкретные значения, определенные в соответствующих классах. 
<br><br><b>3. Просмотр всех существующих товаров по типу. <br></b>
1) Введите ссылку http://localhost:8080/test/products/type/monitor. Слово <i>"monitor"</i> является переменной в пути запроса и может быть заменено на <i>"computer", "harddisk" и "laptop"</i>.
2) Тип запроса - <b> GET </b>.

<b>4. Просмотр товара по идентификатору. <br></b>
Для этого необходимо воспользоваться ссылкой http://localhost:8080/test/products/1, где "1" - идентификатор объекта (тип запроса остается <b> GET </b>, как и в предыдущем пункте). 
