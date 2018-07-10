/* Se crea la base de Datos*/
create database dbInnovasys;
use dbInnovasys;

/* Se crean las tablas*/
create table datosEmpresa(
numRegistro int not null primary key,
nombreEmpresa varchar(80) not null,
domicilioLegal varchar(120) not null,
fechaConstitucion datetime not null,
descripcion text,
logo varchar(120),
telefono int not null,
telefono2 int,
fax int,
fax2 int,
correoElectronico varchar(40),
correoElectronico2 varchar(40),
propietario varchar(60) not null,
noSerieFactura int not null,
noSerieFiscal int not null
);

create table privilegio(
idPrivilegio int not null primary key,
verInventario bit,
construirEquipo bit,
verProductos bit,
solicitarAyuda bit,
verOrdenesCola bit,
verCajaVirtual bit,
verVentasUuario bit,
chatCenter bit,
cambiarDatosEmpresa bit,
gestionarVentas bit,
gestionarBitacoras bit,
gestionarClientes bit,
gestionarProveedores bit,
gestionarEmpleados bit,
gestionarProductos bit,
gestionarInventario bit,
gestionarDevoluciones bit
);


create table tipoUsuario(
idTipo int not null primary key,
nombreTipo varchar(60),
idPrivilegio int not null references privilegio(idPrivilegio)
);


create table estadoEmpleado(
idEstado int not null primary key,
nombreEstado char(50) not null,
descripcion varchar(50) 
);


create table usuarioEmpleado(
idEmpleado int not null primary key,
idTipo int not null references tipoUsuario(idTipo),
nombres varchar(150) not null,
apellidos varchar(150) not null,
telefono int not null,
correoElectronico varchar(70) not null,
contraseña varchar(80) not null,
direccion varchar(120) not null,
idEstado int not null references estadoEmpleado(idEstado)
);




create table documento(
idDocumento int not null primary key,
nombre varchar(80),
estado varchar(80)
);



create table documentoEmpleado(
idDocumentoE int not null primary key,
idDocumento int not null references documento(idDocumento),
idEmpleado int not null references usuarioEmpleado(idEmpleado),
descripcion int not null
);



create table bitacoraEmpleado(
idBitacora int not null primary key,
fechaEntrada datetime,
idEmpleado int not null references usuarioEmpleado(idEmpleado)
);



create table proveedor(
idProveedor int not null primary key,
nombreProveedor varchar(60) not null,
direccion varchar(120),
telefono int not null,
fax int,
correoElectronico varchar(70)
);



create table categoriaProducto(
idCategoria int not null primary key,
nombreCategoria varchar(60),
descripcion text,
visualizacion_3D bit
);

/* Estas 2 tablas se actualizaran para la siguiente defensa*/

create table tag(
idTag int not null primary key,
nombreTag varchar()
);

create table detalle(
idDetalle int not null primay key,
idTag int not null references tag(idTag)
);

create table producto(
idProducto int not null primary key,
idDetalle int not null references tag(),
nombreProducto varchar(60) not null,
descripcion text,
imagen varchar(200),
idProveedor int not null references proveedor(idProveedor),
idCategoria int not null references categoriaProducto(idCategoria),
);





create table tipoTransaccion(
idTipoT int not null primary key,
nombre varchar(60)
);



create table inventario(
idInventario int not null primary key,
idProductos int not null references producto(idProducto),
idTipoT int not null references tipoTransaccion(idTipoT),
fechaTransaccion datetime not null,
precioCompra numeric (5,3) not null,
porcentajeGanacia numeric(5,3) not null,
stock int not null,
cantidad int not null,
impuestos numeric(5,3) not null,
estado varchar(50) not null
);



create table cliente(
idCliente int not null primary key,
nombre varchar(60),
apellido varchar(70),
corporativo bit not null,
dui int not null,
nit int not null,
correoElectronico varchar(70) not null,
contraseña varchar(80),
preguntaSeguridad1 varchar(120),
preguntaSeguridad2 varchar(120),
respuestaSeguridad1 varchar(120),
respuestaSeguridad2 varchar(120),
telefono int
);
--Si ya se tiene la base aqui agrege los campos
ALTER TABLE cliente ADD respuestaSeguridad1 varchar(120),respuestaSeguridad2 varchar(120)


create table bitacoraCliente(
idBitacoraC int not null primary key,
fechaEntrada datetime not null,
idCliente int not null references cliente(idCliente)
);



create table factura(
noFactura int not null primary key,
numRegistro int not null references datosEmpresa(numRegistro),
fecha datetime not null,
idEmpleado int not null references usuarioEmpleado(idEmpleado),
idCliente int not null references cliente(idCliente),
montoTotal numeric(5,3) not null
);



create table detalleFactura(
idDetalle int not null primary key,
noFactura int not null references factura(noFactura),
idProducto int not null references producto(idProducto),
cantidadProducto int not null
);



create table estadoPedido(
idEstadoP int not null primary key,
nombre varchar(80),
descripcion varchar(120)
);




create table pedido(
idPedido int not null primary key,
fecha datetime not null,
fecha_vencimiento datetime not null,
idEstadoP int not null references estadoPedido(idEstadoP),
idCliente int not null references cliente(idCliente),
monto_total numeric(5,3) not null
);




create table detallePedido(
idDetalleP int not null primary key,
idPedido int not null references pedido(idPedido),
idProducto int not null references producto(idProducto),
cantidadProducto numeric(5,3) not null
);



create table creditoFiscal(
noCreditoFiscal int not null primary key,
numRegistro int not null references datosEmpresa(numRegistro),
fecha datetime,
idEmpleado int not null references usuarioEmpleado(idEmpleado),
idCliente int not null references cliente(idCliente),
iva numeric (5,3),
retencion numeric (5,3),
extento numeric (5,3),
monto_total numeric(5,3) not null,
observaciones varchar(120),
cancelado bit
);



create table detalleCreditoFiscal(
idDetalle int not null primary key,
noCreditoFiscal int not null references creditoFiscal(noCreditoFiscal),
idProducto int not null references producto(idProducto),
cantidadProducto int not null,
precioImpuestos numeric (5,3),
precioSinImpuestos numeric(5,3)
);



create table notasCreditoFiscal(
noNCredito int not null primary key,
noCredito_fiscal int not null references creditoFiscal(noCreditoFiscal),
descripcion varchar(120),
nit int not null,
fecha datetime,
fechaVencimiento datetime,
totalDevuelto numeric(5,3)
);


/*Se ingresan los registros a las tablas*/

insert into datosEmpresa values(1,'CompuService','1era Calle Poniente 16ta Av. Norte, San Salvador','03/01/18',' Empresa dedicada a comercializar productos informaticos','imagenes/logo.png',77554433,22060503,22060504,22060503,'compuservice@gmail.com','compuservice2@gmail.com','Ing.Steven Diaz',12000,13000)


insert into privilegio values(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)
insert into privilegio values(2,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0)
insert into privilegio values(3,1,1,1,1,1,1,1,1,1,0,0,0,0,1,1,1,1)
insert into privilegio values(4,1,1,1,1,1,0,0,0,0,1,1,1,1,1,1,1,1)
insert into privilegio values(5,1,0,0,0,0,1,1,1,1,1,1,1,1,1,1,1,1)


insert into tipoUsuario values(1,'Administrador',1)
insert into tipoUsuario values(2,'Cajero',2)
insert into tipoUsuario values(3,'Vendedor',3)
insert into tipoUsuario values(4,'Cliente',4)
insert into tipoUsuario values(5,'Soporte',5)


insert into estadoEmpleado(idEstado,nombreEstado) values(1,'Activo')
insert into estadoEmpleado(idEstado,nombreEstado) values(2,'Inactivo')
insert into estadoEmpleado(idEstado,nombreEstado) values(3,'Despedido')
insert into estadoEmpleado(idEstado,nombreEstado) values(4,'Incapacitado')
insert into estadoEmpleado(idEstado,nombreEstado) values(5,'Suspendido')


insert into usuarioEmpleado values(1,1,'Steven','Diaz',77814435,'stevenbdf@gmail.com','qwerty321','San Salvador',1)
insert into usuarioEmpleado values(2,2,'Boris','Huezo',77814436,'boris@gmail.com','qwerty321','San Salvador',2)
insert into usuarioEmpleado values(3,3,'Carlos','Miguel',77814437,'carlos@gmail.com','qwerty321','San Salvador',3)
insert into usuarioEmpleado values(4,4,'Josue','Duran',77814438,'josue@gmail.com','qwerty321','San Salvador',4)
insert into usuarioEmpleado values(5,5,'Sebastian','Jimenez',77814439,'sebastian@gmail.com','qwerty321','San Salvador',5)


insert into documento values(1,'DUI','activo')
insert into documento values(2,'AFP','activo')
insert into documento values(3,'ISSS','activo')
insert into documento values(4,'NIT','activo')
insert into documento values(5,'Licencia','activo')


insert into documentoEmpleado values(1,1,1,'20170199')
insert into documentoEmpleado values(2,1,2,'20170200')
insert into documentoEmpleado values(3,1,3,'20170201')
insert into documentoEmpleado values(4,1,4,'20170202')
insert into documentoEmpleado values(5,1,5,'20170203')


insert into bitacoraEmpleado values(1,'03/01/18',1)
insert into bitacoraEmpleado values(2,'03/01/18',2)
insert into bitacoraEmpleado values(3,'03/01/18',3)
insert into bitacoraEmpleado values(4,'03/01/18',4)
insert into bitacoraEmpleado values(5,'03/01/18',5)


insert into proveedor values(1,'NVIDIA','E.U.A, CA, Ocean St.147',105237784,105237785,'nvidia@gmail.com')
insert into proveedor values(2,'ASUS','E.U.A, CA, Ocean St.148',105237786,105237787,'asus@gmail.com')
insert into proveedor values(3,'HP','E.U.A, CA, Ocean St.149',105237788,105237789,'hp@gmail.com')
insert into proveedor values(4,'MSI','E.U.A, CA, Ocean St.150',105237790,105237791,'msi@gmail.com')
insert into proveedor values(5,'Intel','E.U.A, CA, Ocean St.151',105237792,105237793,'intel@gmail.com')


insert into categoriaProducto values(1,'Periferico',' ',0)
insert into categoriaProducto values(2,'CABLE',' ',1)
insert into categoriaProducto values(3,'EXTRA',' ',0)
insert into categoriaProducto values(4,'Electrico',' ',1)
insert into categoriaProducto values(5,'Memorias',' ',0)


insert into producto values(1,'Mouse',' ','imagenes/mouse.png',1,1)
insert into producto values(2,'32 Pines Conector',' ','imagenes/12pines.png',2,2)
insert into producto values(3,'Maletin p/ Laptop',' ','imagenes/MpLaptop.png',3,3)
insert into producto values(4,'Tester RJ45',' ','imagenes/tester45.png',4,4)
insert into producto values(5,'USB 16GB 3.1',' ','imagenes/16GB3_1.png',5,5)


insert into tipoTransaccion values(1,'Entrada')
insert into tipoTransaccion values(2,'Salida')


insert into inventario values(1,1,1,'03/01/18',50.63,0.55,10,55,0.22,'Recibido')
insert into inventario values(2,2,2,'04/01/18',25.75,0.55,10,55,0.22,'Entregado')
insert into inventario values(3,3,1,'05/01/18',20.15,0.55,10,55,0.22,'Recibido')
insert into inventario values(4,4,1,'06/01/18',18.55,0.55,10,55,0.22,'Recibido')
insert into inventario values(5,5,1,'07/01/18',13.99,0.55,10,55,0.22,'Recibido')


insert into cliente values(1,'Claudia','Gonzalez',0,20170100,20170101,'claudia@gmail.com','qwerty321','¿Cual es el nombre de tu primer mascota?','¿Color favorito?','Maria','amarillo',7644588)
insert into cliente values(2,'Ada','Gonzalez',0,20170102,20170103,'ada@gmail.com','qwerty321','¿Cual es el nombre de tu primer mascota?','¿Color favorito?','Maria','amarillo',7644589)
insert into cliente values(3,'Jose','Guzman',0,20170104,20170105,'jose@gmail.com','qwerty321','¿Cual es el nombre de tu primer mascota?','¿Color favorito?','Maria','amarillo',7644590)
insert into cliente values(4,'Andres','Urrutia',0,20170106,20170107,'andres@gmail.com','qwerty321','¿Cual es el nombre de tu primer mascota?','¿Color favorito?','Maria','amarillo',7644591)
insert into cliente values(5,'Diego','Cortez',0,20170108,20170109,'diego@gmail.com','qwerty321','¿Cual es el nombre de tu primer mascota?','¿Color favorito?','Maria','amarillo',7644592)


insert into bitacoraCliente values(1,'03/01/18',1)
insert into bitacoraCliente values(2,'03/01/18',2)
insert into bitacoraCliente values(3,'03/01/18',3)
insert into bitacoraCliente values(4,'03/01/18',4)
insert into bitacoraCliente values(5,'03/01/18',5)


insert into factura values(12001,1,'03/01/18',1,1,12.55)
insert into factura values(12002,1,'03/01/18',2,2,25.60)
insert into factura values(12003,1,'03/01/18',3,3,20.50)
insert into factura values(12004,1,'03/01/18',4,4,15.15)
insert into factura values(12005,1,'03/01/18',5,5,10.10)


insert into detalleFactura values(1,12001,1,2)
insert into detalleFactura values(2,12001,2,1)
insert into detalleFactura values(3,12001,3,6)
insert into detalleFactura values(4,12001,4,8)
insert into detalleFactura values(5,12001,5,10)


insert into estadoPedido values (1,'Activo',' ')
insert into estadoPedido values (2,'Efectuado',' ')
insert into estadoPedido values (3,'Reservado',' ')
insert into estadoPedido values (4,'En Construccion',' ')
insert into estadoPedido values (5,'Inactivo',' ')


insert into pedido values(1,'03/01/18','03/01/19',1,1,25.66)
insert into pedido values(2,'03/01/18','03/01/19',2,4,21.66)
insert into pedido values(3,'03/01/18','03/01/19',3,3,23.66)
insert into pedido values(4,'03/01/18','03/01/19',4,2,24.66)
insert into pedido values(5,'03/01/18','03/01/19',5,1,26.66)


insert into detallePedido values(1,1,1,15.00)
insert into detallePedido values(2,1,2,11.00)
insert into detallePedido values(3,2,3,11.00)
insert into detallePedido values(4,3,4,12.00)
insert into detallePedido values(5,5,5,13.00)


insert into creditoFiscal values(13001,1,'03/01/18',1,1,15.45,0.0,0.0,60.55,' ',1)
insert into creditoFiscal values(13002,1,'03/01/18',2,2,15.45,0.0,0.0,60.55,' ',0)
insert into creditoFiscal values(13003,1,'03/01/18',3,3,15.45,0.0,0.0,60.55,' ',1)
insert into creditoFiscal values(13004,1,'03/01/18',4,4,15.45,0.0,0.0,60.55,' ',0)
insert into creditoFiscal values(13005,1,'03/01/18',5,5,15.45,0.0,0.0,60.55,' ',1)


insert into detalleCreditoFiscal values(1,13001,1,13,12.55,10.55)
insert into detalleCreditoFiscal values(2,13002,2,13,12.55,10.55)
insert into detalleCreditoFiscal values(3,13003,3,13,12.55,10.55)
insert into detalleCreditoFiscal values(4,13004,4,13,12.55,10.55)
insert into detalleCreditoFiscal values(5,13005,5,13,12.55,10.55)


insert into notasCreditoFiscal values(1,13001,' ',75758484,'03/10/18','03/10/19',10.55)
insert into notasCreditoFiscal values(2,13001,' ',75758484,'03/10/18','03/10/19',10.55)
insert into notasCreditoFiscal values(3,13001,' ',75758484,'03/10/18','03/10/19',10.55)
insert into notasCreditoFiscal values(4,13001,' ',75758484,'03/10/18','03/10/19',10.55)
insert into notasCreditoFiscal values(5,13001,' ',75758484,'03/10/18','03/10/19',10.55)
