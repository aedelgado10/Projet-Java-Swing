INSERT INTO Collaborateur VALUES(1,'Aoun','Andre','aoun','aoun@irit.fr','papaaoun');
INSERT INTO Collaborateur VALUES(2,'Desprats','Thierry','desprats','desprats@irit.fr','papadesprats');

INSERT INTO Administrateur VALUES(1);

INSERT INTO ETRE VALUES(1,1);

INSERT INTO MESSAGE VALUES(1,'Nous avons un souci avec les L3 STRI, ils sont nuls en java....','2016/05/27','09:00','1');
INSERT INTO MESSAGE VALUES(2,'oh non, ne me dis pas ça stp...','2016/05/27','09:18','1');

INSERT INTO Salle VALUES(1,'Public','Discussion Enseignants STRI','STRI','2016/05/26');

INSERT INTO DROITS VALUES(1,'Droit admin','1','1','1');
INSERT INTO DROITS VALUES(2,'Droit normal','0','1','0');
INSERT INTO DROITS VALUES(3,'Droit restreint','0','0','0');

INSERT INTO AVOIR_DROITS_DANS_SALLE VALUES(1,1,1);
INSERT INTO AVOIR_DROITS_DANS_SALLE VALUES(2,2,1);

INSERT INTO CREER VALUES(1,1);

INSERT INTO AFFECTER VALUES(1,1,1);
INSERT INTO AFFECTER VALUES(1,1,2);

INSERT INTO SE_CONNECTER VALUES(1,1);
INSERT INTO SE_CONNECTER VALUES(2,1);

INSERT INTO ENVOYER VALUES(1,1,1);
INSERT INTO ENVOYER VALUES(2,2,1);

