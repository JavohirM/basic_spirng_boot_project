package uz.writer.dao.title;

public class TitleCSV {


    public static final String[] PORT_LD_10_TITLES = {
            "№ анкеты",
            "кредит йигмажилди коди",
            "STATUS",
            "Заявка раками",
            "Код Государственного Нормативного Акта",
            "Хисоб раками",
            "Вилоят коди",
            "Банк филиали МФО раками",
            "Мижознинг тулик номи",
            "Жис / юр / Ятт",
            "Жис / юр / Ятт - коди",
            "Тип Заемщика",
            "ИНН",
            "Дата рождения клиента (физ. лицо)",
            "Код  района клиента",
            "Наименование района клиента",
            "№ норм. прав. акта",
            "Дата норм. прав. акта",
            "Кредит кумитаси карори тартиб раками",
            "Кредит кумитаси карори тартиб санаси",
            "Кредит шартномаси тартиб раками",
            "Кредит шартномаси тартиб санаси",
            "Шартнома буйича  кредит микдори (номинал)",
            "Шартнома буйича  кредит микдори (Эквивалент)",
            "Кафолатчининг номи (таъминонинг тулик номи)",
            "Жами берилган кредит микдори (номинал)",
            "Жами берилган кредит микдори (эквивалент)",
            "Шу йил учун берилган кредит микдори (номинал)",
            "Шу йил учун берилган кредит микдори (эквивалент)",
            "0- Накдсиз   1- Накд",
            "Хисобот даврида муддати утган -сана",
            "Шу йил учун берилган кредит микдори (количество)",
            "Юкори ташкилот коди",
            "Шартнома буйича дастлабки берилган кредит микдори",
            "Хисобот кунига кредит колдиги",
            "Эквивалентда хисобот даврида кредит колдиги",
            "Муддати утган кредит хисоб раками",
            "Хисобот даврида муддати утган кредит колдиги",
            "Хисобот даврида муддати утган кредит колдиги - экв",
            "Ссуда хисоб раками буйича сунгги бухгалтерия утказмаси (дата последний проводки)",
            "Муддати утган кредит хисоб раками буйича сунгги бухгалтерия утказмаси",
            "Валюта коди",
            "Кредит бериш манбаи - номи",
            "Кредит бериш манбаи - коди",
            "Зарубежная фин. Организация",
            "Источник фин-я по АБР",
            "Кредит кайси максадда берилган",
            "Яратилган иш урни режа",
            "Кредит максади - коди",
            "Тармок коди",
            "ОКОНХ",
            "ОКЭД",
            "ОКЭД -расшифровка",
            "Йиллик фоиз ставкаси (% да)",
            "Шартнома буйича ставкаси (%)",
            "Кредит берилган сана (кун,ой,йил)",
            "Кредит берилган охирги сана (кун,ой,йил)",
            "Кредит берилган охирги сумма",
            "Шартномага асосан кайтариш муддати (кун,ой,йил)",
            "Погашение в тек. Месяце",
            "Предстоящие погашения в тек. +1 месяце",
            "Предстоящие погашения в тек. +2 месяце",
            "Кредит таъминоти номи",
            "Кредит таъминоти коди",
            "Кредит таъминоти коди max",
            "Кредит таъминоти суммаси",
            "Хисобланган лекин тулаш муддати далмаган фоиз микдори (16309, 16323) -номинал",
            "Хисобланган лекин тулаш муддати келмаган фоиз микдори (16309, 16323) -эквивалент",
            "Сўнгги бухгалтерия ўтказмаси (16309, 16323)(дата последний проводки)",
            "Хисобланган лекин тулаш муддати утган фоиз микдори (16377)- номинал",
            "Хисобланган лекин тулаш муддати утган фоиз микдори (16377)- эквивалент",
            "Сўнгги бухгалтерия ўтказмаси (16377)  (дата последний проводки деб оборот)",
            "Общая сумма начисленных %(экв)",
            "Общая сумма погашенных %(экв)",
            "Жами сундирилган",
            "Текущие проценты за балансом (91501, 91503) - номинал",
            "Текущие проценты за балансом (91501, 91503) - эквивалент",
            "Просроч проценты за балансом (91501, 91503) - номинал",
            "Просроч проценты за балансом (91501, 91503) - эквивалент",
            "Сўнгги бухгалтерия ўтказмаси (91501, 91503)(дата последний проводки)",
            "91901/91905-Карзодорларнинг киска/узок муддатли кредиталар ва лизинглар буйича мажбуриятлари",
            "94501- Гаров сифатида олинган кимматли когозлар",
            "94502 Гаров сифатида олинган мол-мулклар ва мулкий хукук (талаб)лар",
            "94503-Гаров сифатида олинган кафолат ва кафилликлар",
            "Кредит ва лизинг бўйича балансдан ўчирилган асосий ?арз ?олди?и (95413)-номинал",
            "Кредит ва лизинг бўйича балансдан ўчирилган асосий ?арз ?олди?и(95413)- эквивалент",
            "Сўнгги бухгалтерия ўтказмаси 95413)(дата последний проводки",
            "Кредит бериш буйича хукумат карори",
            "Хукумат кафолати берилган сана",
            "Кредит таснифи номи",
            "Кредит таснифи коди",
            "Кредит буйича шакллантирилган захира",
            "Кредит буйича шакллантирилган захира- эквивалент",
            "Кредит берган банк (филиал) бошкарувчиси исми шарифи",
            "Тип кредита (код)",
            "Тип кредита",
            "Шифр кредитования (код)",
            "Шифр кредитования",
            "Шифр кредитования ЦБ(код)",
            "Шифр кредитования ЦБ",
            "Судга даъво аризаси тушган сана",
            "Суд ижро карори санаси",
            "Бошка маълумотлар",
            "Хукукни мухофаза килувчи органлар коди тугрисидаги маълумотларни киритиб беришингизни сураймиз",
            "Карорнинг кимнинг фойдасига хал киоинганлиги",
            "ФИО ответственного сотрудника",
            "Департимент коди",
            "Срочность кредита",
            "Ходимлар сони",
            "Муддатлари буйича(код)",
            "Классификатор код",
            "Классификатор название",
            "дата погашения 1-го транша",
            "страх. Компания",
            "истечение полиса",
            "финансирование инвест. проекта",
            "16405",
            "16413 срочн.",
            "16413 проср.",
            "Комиссия за управление",
            "Метод начисления",
            "Дата погашения осн. долга",
            "Сумма погашения осн.долга",
            "Дата погашения %",
            "Сумма погашения %",
            "% по просроченной задолженности",
            "дата начала действия ставки",
            "код зарубежно финансовой организации",
            "Сумма последнего КТ оборота по счету просроч. Задолжености",
            "Счет выдачи кредита",
            "кредит максади(расшифровка)",
            "основной вид деятельности",
            "тармок(расшифровка)",
            "Залог имущества",
            "Недвижимость",
            "Недвижимость (ипотека)",
            "Транспортные средства",
            "Оборудование",
            "Депозит",
            "Товарно-материальные ценности(инвентарь)",
            "Товары в обороте",
            "Векселя",
            "Акции",
            "Облигации",
            "Государственные ценные бумаги",
            "Права земельной аренды",
            "Будущий урожай",
            "Депозитные сертификаты",
            "Не оплаченные счета (дебит.задолж.)",
            "Ипотечные ценные бумаги (закладная)",
            "Крупный рогатый скот",
            "Паевые взносы",
            "Ювелирные изделия",
            "Поручительства и гарантии",
            "Поручительство третьих лиц",
            "Гарантия Правительства",
            "Гарантия третьей стороны",
            "Страховой полис 50",
            "Страховой полис 51",
            "Без обеспечения 60",
            "Без обеспечения 61",
            "Фермерское или Дехканское хозяйство",
            "50% женщины или женщина руководитель",
            "Кол-во раб.мест на момент получения кредита",
            "Создаваемые раб.места по Б/П",
            "Молодая семья",
            "Микрокредит молодым семьям",
            "Микрокредит на формирование первоначального капитала",
            "Производство продовольственных и непродовольственных товаров",
            "Выпусник колледжа",
            "Семейный предприниматель",
            "Личное подсобное хозяйство",
            "Ремесленничество",
            "Кредиты на покупку технологического оборудования",
            "Кредиты выделенные в сельской местности",
            "Молодые предприниматели (до 30 лет)",
            "Экспортер",
            "Связанные лица",
            "Инвестиционный кредит или лизинг",
            "Потребительские кредиты на приобретении бытовых и кухонных электроприборов для облегчения труда женщин",
            "Половая принадлежность",
            "Просроченные проценты (номинал)",
            "Просроченные проценты (эквивалент)",
            "Код в базе ЗР",
            "Наим. оценочной компании",
            "№ отчета об оценке",
            "Минибанк",
            "Название минибанка",
            "Общая сумма начисленных %(ном)",
            "Общая сумма погашенных %(ном)",
            "Балансовый счет",
            "Дата выхода  % на просрочку",
            "Код клиента",
            "Учет Ссудных обязательств (ном)",
            "Учет Ссудных обязательств (экв)",
            "Счет учета Ссудных обязательств;",
            "Дата выхода на просрочку (Ravnaq)",
            "Категория кредитов, требующих  особого внимания",
            "Статус ссуды (код)",
            "Статус ссуды (наименование)",
            "счет %% льготного периода",
            "сумма %% льготного периода",
            "Изменение условий кредитного договора",
            "Кредит пересмотренный в связи с пандемией",
            "Серия и номер паспорта"};
}
