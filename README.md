# VODA #
## Description ##
Некий черновик нужндающаяся в доработке
Полностью функционал не реализован
Хранение кода в таком виде не безопасно (коды ботов)
Хранение кода в таком виде только для ознакомления
Это нивкоем случае не релиз и не бета
Используется как есть

## Как это работает: ##
draft: - обработка входящей печатной речи и преобразование в события
--Clubs - бот для помощи ведения клубной деятельности (активности)
--Fitlife24 - бот для фит-клубов
--Plank - входное онлайн мероприятие для активации активности человека (первые результаты)
--Popejbot - демо-бот, для демонстрации возможностей
--RezultDiary - бот для сбора результатов людей
--Statistica - деловая статистика (конверсионность)
--Test - пример как хотелось хранить диалоги (сейчас не актульно, сейчас хочется переделать под БД)
Model: - работа с бд (CRUD - не реализован, нужно реализовывать)
--dbmodel
---MysqlCon
---Java DB [!!!]
---sqllite
Results - классы для описания физических параметров тела => @deprecated
Sheduler - события-таймеры на отправку сообщений => updateit! нужно обновить! (работа через БД одним шедулиром разными ботами)
View - клавиатуры (вынести настройки в БД)

copy xsa 2018