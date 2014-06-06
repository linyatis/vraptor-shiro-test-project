vraptor-shiro-test-project
==========================

Usuário admin possui permissões add, edit, delete e read.   
Qualquer outro nome de usuário deve funcionar, porém apenas com permissão read.  
Senha para qualquer usuário (inclusive admin) é 123456  

#####Testes feitos com Tomcat 7.0.50

###URIs para teste:

/ (index)    
/login (login)    
   
/add (aplicada autorização com anotação)    
/edit (aplicada autorização com anotação)    
/delete (aplicada autorização com anotação)    
/read (aplicada autorização com anotação)    
    
/add2 (aplicada autorização programaticamente)  
/edit2 (aplicada autorização programaticamente)  
/delete2 (aplicada autorização programaticamente)  
/read2 (aplicada autorização programaticamente)  
