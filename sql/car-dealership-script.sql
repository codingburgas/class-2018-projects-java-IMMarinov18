USE [master]
GO
/****** Object:  Database [Car Dealership]    Script Date: 6/3/2022 3:01:32 PM ******/
CREATE DATABASE [Car Dealership]

GO
USE [Car Dealership]
GO
/****** Object:  Table [dbo].[Car]    Script Date: 6/3/2022 3:01:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Car](
	[CarId] [int] NOT NULL,
	[Category] [nvarchar](50) NULL,
	[Model] [nvarchar](50) NULL,
	[Year] [int] NULL,
	[SerialNumber] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[CarId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DealershipEstate]    Script Date: 6/3/2022 3:01:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DealershipEstate](
	[id] [int] NOT NULL,
	[Address] [nvarchar](50) NULL,
	[PhoneNumber] [int] NULL,
	[Area] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 6/3/2022 3:01:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Role](
	[id] [int] NOT NULL,
	[RoleName] [nvarchar](50) NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SalesInvoice]    Script Date: 6/3/2022 3:01:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalesInvoice](
	[id] [int] NOT NULL,
	[InvoiceNumber] [int] NULL,
	[Date] [nvarchar](50) NULL,
	[CarId] [int] NULL,
	[UserId] [int] NULL,
	[SalesPersonId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SalesPerson]    Script Date: 6/3/2022 3:01:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SalesPerson](
	[id] [int] NOT NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](50) NULL,
	[PhoneNumber] [int] NULL,
	[Email] [nvarchar](50) NULL,
	[DealershipEstateId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 6/3/2022 3:01:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[id] [int] IDENTITY(1,1) NOT NULL,
	[FirstName] [nvarchar](50) NOT NULL,
	[LastName] [nvarchar](50) NOT NULL,
	[PhoneNumber] [int] NOT NULL,
	[City] [nvarchar](50) NOT NULL,
	[Address] [nvarchar](50) NOT NULL,
	[State] [nvarchar](50) NOT NULL,
	[PostalCode] [int] NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[UserName] [nvarchar](50) NOT NULL,
	[Password] [nvarchar](50) NOT NULL,
	[Car_id] [int] NOT NULL,
 CONSTRAINT [PK__User__3213E83F223CC63C] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserRole]    Script Date: 6/3/2022 3:01:32 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[UserRole](
	[UserId] [int] NOT NULL,
	[RoleId] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[UserId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Car] ([CarId], [Category], [Model], [Year], [SerialNumber]) VALUES (1, N'Sedan', N'A8', 2018, 11)
GO
INSERT [dbo].[Car] ([CarId], [Category], [Model], [Year], [SerialNumber]) VALUES (2, N'Sedan', N'S-class', 2020, 12)
GO
INSERT [dbo].[Car] ([CarId], [Category], [Model], [Year], [SerialNumber]) VALUES (3, N'Sedan', N'750li', 2020, 13)
GO
SET IDENTITY_INSERT [dbo].[User] ON 
GO
INSERT [dbo].[User] ([id], [FirstName], [LastName], [PhoneNumber], [City], [Address], [State], [PostalCode], [Email], [UserName], [Password], [Car_id]) VALUES (1, N'Ilia', N'Marinov', 11223344, N'Sofia', N'Sofia', N'Sofia', 8000, N'iliikata@bg', N'iliikata', N'123456789', 1)
GO
INSERT [dbo].[User] ([id], [FirstName], [LastName], [PhoneNumber], [City], [Address], [State], [PostalCode], [Email], [UserName], [Password], [Car_id]) VALUES (2, N'Stoqn', N'Ponchev', 123, N'Burgas', N'Burgas', N'Burgas', 8000, N'stoqn@bg', N'Stoqncho', N'1234', 2)
GO
INSERT [dbo].[User] ([id], [FirstName], [LastName], [PhoneNumber], [City], [Address], [State], [PostalCode], [Email], [UserName], [Password], [Car_id]) VALUES (3, N'Petar', N'Petkov', 1234, N'Burgas', N'Burgas', N'Burgas', 8000, N'petar@bg', N'petar', N'123456', 3)
GO
SET IDENTITY_INSERT [dbo].[User] OFF
GO
ALTER TABLE [dbo].[SalesInvoice]  WITH CHECK ADD  CONSTRAINT [FK_SalesInvoice.SalesPersonId] FOREIGN KEY([SalesPersonId])
REFERENCES [dbo].[SalesPerson] ([id])
GO
ALTER TABLE [dbo].[SalesInvoice] CHECK CONSTRAINT [FK_SalesInvoice.SalesPersonId]
GO
ALTER TABLE [dbo].[SalesInvoice]  WITH CHECK ADD  CONSTRAINT [FK_SalesInvoice.UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[SalesInvoice] CHECK CONSTRAINT [FK_SalesInvoice.UserId]
GO
ALTER TABLE [dbo].[SalesPerson]  WITH CHECK ADD  CONSTRAINT [FK_SalesPerson.DealershipEstateId] FOREIGN KEY([DealershipEstateId])
REFERENCES [dbo].[DealershipEstate] ([id])
GO
ALTER TABLE [dbo].[SalesPerson] CHECK CONSTRAINT [FK_SalesPerson.DealershipEstateId]
GO
ALTER TABLE [dbo].[User]  WITH CHECK ADD  CONSTRAINT [FK_User_Car] FOREIGN KEY([Car_id])
REFERENCES [dbo].[Car] ([CarId])
GO
ALTER TABLE [dbo].[User] CHECK CONSTRAINT [FK_User_Car]
GO
ALTER TABLE [dbo].[UserRole]  WITH CHECK ADD  CONSTRAINT [FK_UserRole.RoleId] FOREIGN KEY([RoleId])
REFERENCES [dbo].[Role] ([id])
GO
ALTER TABLE [dbo].[UserRole] CHECK CONSTRAINT [FK_UserRole.RoleId]
GO
ALTER TABLE [dbo].[UserRole]  WITH CHECK ADD  CONSTRAINT [FK_UserRole.UserId] FOREIGN KEY([UserId])
REFERENCES [dbo].[User] ([id])
GO
ALTER TABLE [dbo].[UserRole] CHECK CONSTRAINT [FK_UserRole.UserId]
GO
USE [master]
GO
ALTER DATABASE [Car Dealership] SET  READ_WRITE 
GO
