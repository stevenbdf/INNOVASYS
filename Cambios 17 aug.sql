use dbInnovasys
select * from cliente
select * from inventario
select * from usuarioEmpleado
update usuarioEmpleado set respuesta1='no' , respuesta2='no'
update cliente set correoElectronico='stevenbdf@gmail.com' where idCliente=(SELECT MAX(idCliente) from cliente)
select * from pedido where idCliente=1 and idEstadoP=5
SELECT * FROM detallePedido
select * from estadoPedido where idEstadoP!=5

select * from factura
select * from detalleFactura
select * from detallePedido

alter table factura
alter column fecha date

alter table factura
alter column montoTotal float


alter table pedido 
alter column fecha_vencimiento date

alter table pedido 
alter column fecha date

alter table detallePedido 
alter column cantidadProducto int

alter table pedido 
alter column monto_total float

alter table inventario
alter column precioCompra float

alter table inventario
alter column porcentajeGanacia float 

alter table inventario
alter column impuestos float

alter table cliente 
add RespuestaSeguridad1 varchar(200),
RespuestaSeguridad2 varchar (200),
fechaRegistro date

alter table cliente
alter column fechaRegistro date

alter table inventario 
alter column fechaTransaccion date