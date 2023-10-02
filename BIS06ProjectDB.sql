create table LOB(
idLOB number constraint pk_LOB primary key,
NombreLOB varchar(50)
);

create table MetricasOperacionales(
idMetricaOps number constraint pk_MetricasOperacionales primary key,
NombreMetrica varchar(50),
goal number
);

create table MetricasCalidad(
idMetricaQA number constraint pk_MetricasCalidad primary key,
NombreAtributo varchar(50),
goal number
);

create table SetMetricasOps(
LineOfBis constraint fk1_SetMetricasOps references LOB,
Metrica constraint fk2_SetMetricasOps references MetricasOperacionales,
score number,
primary key (LineOfBis, Metrica)
);

create table SetMetricasQA(
LineOfBis constraint fk1_SetMetricasQA references LOB,
Atributo constraint fk2_SetMetricasQA references MetricasCalidad,
score number,
primary key (LineOfBis, Atributo)
);

create table newsUpdates(
LOBs constraint fk1_newsUpdates references LOB,
idnewsUpdates number,
News varchar2(1000),
primary key (LOBs, idnewsUpdates));


Insert into LOB (idLOB, NombreLOB) values (01, 'Linea 01');
Insert into LOB (idLOB, NombreLOB) values (02, 'Linea 02');
Insert into LOB (idLOB, NombreLOB) values (03, 'Linea 03');
Insert into LOB (idLOB, NombreLOB) values (04, 'Linea 04');
Insert into LOB (idLOB, NombreLOB) values (05, 'Linea 05');
Insert into LOB (idLOB, NombreLOB) values (06, 'Linea 06');
Insert into LOB (idLOB, NombreLOB) values (07, 'Linea 07');
Insert into LOB (idLOB, NombreLOB) values (08, 'Linea 08');
Insert into LOB (idLOB, NombreLOB) values (09, 'Linea 09');
Insert into LOB (idLOB, NombreLOB) values (10, 'Linea 10');
Insert into LOB (idLOB, NombreLOB) values (11, null);
Insert into LOB (idLOB, NombreLOB) values (12, null);
Insert into LOB (idLOB, NombreLOB) values (13, null);
Insert into LOB (idLOB, NombreLOB) values (14, null);
Insert into LOB (idLOB, NombreLOB) values (15, null);
Insert into LOB (idLOB, NombreLOB) values (16, null);
Insert into LOB (idLOB, NombreLOB) values (17, null);
Insert into LOB (idLOB, NombreLOB) values (18, null);
Insert into LOB (idLOB, NombreLOB) values (19, null);
Insert into LOB (idLOB, NombreLOB) values (20, null);

Insert into MetricasOperacionales (idMetricaOps, NombreMetrica, goal) values (01, 'CSAT', null);
Insert into MetricasOperacionales (idMetricaOps, NombreMetrica, goal) values (02, 'IR', null);


Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (01, 'QSS', 90);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (02, 'Assure', null);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (03, 'Knowledge', 92);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (04, 'Guidance', null);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (05, 'Professionalism', null);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (06, 'Responsiveness', 92);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (07, 'Efficiency', 92);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (08, 'Logging', null);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (09, 'Service', null);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (10, 'Exceptions', null);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (11, 'Consultations', null);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (12, 'Ownership', null);
Insert into MetricasCalidad (idMetricaQA, NombreAtributo, goal) values (13, 'Compliance', 95);

Insert into newsUpdates (LOBs, idnewsUpdates, News) values (05, 01, "Si estas viendo esto, buenas noticias! Haz logrado cargar la informacion desde la base de datos");
Insert into newsUpdates (LOBs, idnewsUpdates, News) values (05, 02, "Ojala que al profesor le agrade la aplicación y me asigne un 100% en la nota");

Insert into newsUpdates (LOBs, idnewsUpdates, News) values (04, 01, "Si estas viendo esto, buenas noticias! Haz logrado cargar la informacion desde la base de datos");
Insert into newsUpdates (LOBs, idnewsUpdates, News) values (04, 02, "Ojala que al profesor le agrade la aplicación y me asigne un 100% en la nota");

Insert into newsUpdates (LOBs, idnewsUpdates, News) values (03, 01, "Si estas viendo esto, buenas noticias! Haz logrado cargar la informacion desde la base de datos");
Insert into newsUpdates (LOBs, idnewsUpdates, News) values (03, 02, "Ojala que al profesor le agrade la aplicación y me asigne un 100% en la nota");

Insert into newsUpdates (LOBs, idnewsUpdates, News) values (02, 01, "Si estas viendo esto, buenas noticias! Haz logrado cargar la informacion desde la base de datos");
Insert into newsUpdates (LOBs, idnewsUpdates, News) values (02, 02, "Ojala que al profesor le agrade la aplicación y me asigne un 100% en la nota");

Insert into newsUpdates (LOBs, idnewsUpdates, News) values (01, 01, "Si estas viendo esto, buenas noticias! Haz logrado cargar la informacion desde la base de datos");
Insert into newsUpdates (LOBs, idnewsUpdates, News) values (01, 02, "Ojala que al profesor le agrade la aplicación y me asigne un 100% en la nota");

Insert into newsUpdates (LOBs, idnewsUpdates, News) values (00, 01, "Si estas viendo esto, buenas noticias! Haz logrado cargar la informacion desde la base de datos");
Insert into newsUpdates (LOBs, idnewsUpdates, News) values (00, 02, "Ojala que al profesor le agrade la aplicación y me asigne un 100% en la nota");

Insert into SetMetricasOps (LineOfBis, Metrica, score) values (05, 01, 85);
Insert into SetMetricasOps (LineOfBis, Metrica, score) values (05, 02, 90);

Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 03, 86);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 04, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 05, 92);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 06, 90);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 07, 87);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 08, 93);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 09, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 10, 20);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 11, 67);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 12, null);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (05, 13, 100);

Insert into SetMetricasOps (LineOfBis, Metrica, score) values (04, 01, 85);
Insert into SetMetricasOps (LineOfBis, Metrica, score) values (04, 02, 90);

Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 03, 86);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 04, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 05, 92);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 06, 90);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 07, 87);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 08, 93);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 09, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 10, 20);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 11, 67);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 12, null);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (04, 13, 100);

Insert into SetMetricasOps (LineOfBis, Metrica, score) values (03, 01, 85);
Insert into SetMetricasOps (LineOfBis, Metrica, score) values (03, 02, 90);

Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 03, 86);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 04, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 05, 92);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 06, 90);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 07, 87);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 08, 93);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 09, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 10, 20);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 11, 67);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 12, null);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (03, 13, 100);

Insert into SetMetricasOps (LineOfBis, Metrica, score) values (02, 01, 85);
Insert into SetMetricasOps (LineOfBis, Metrica, score) values (02, 02, 90);

Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 03, 86);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 04, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 05, 92);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 06, 90);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 07, 87);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 08, 93);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 09, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 10, 20);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 11, 67);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 12, null);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (02, 13, 100);

Insert into SetMetricasOps (LineOfBis, Metrica, score) values (01, 01, 85);
Insert into SetMetricasOps (LineOfBis, Metrica, score) values (01, 02, 90);

Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 03, 86);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 04, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 05, 92);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 06, 90);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 07, 87);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 08, 93);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 09, 100);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 10, 20);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 11, 67);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 12, null);
Insert into SetMetricasQA (LineOfBis, Atributo, score) values (01, 13, 100);


