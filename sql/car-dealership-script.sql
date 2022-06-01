USE [master]
GO
/****** Object:  Database [Car Dealership]    Script Date: 6/1/2022 2:56:25 PM ******/
CREATE DATABASE [Car Dealership1]
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Car Dealership].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Car Dealership] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Car Dealership] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Car Dealership] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Car Dealership] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Car Dealership] SET ARITHABORT OFF 
GO
ALTER DATABASE [Car Dealership] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Car Dealership] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Car Dealership] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Car Dealership] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Car Dealership] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Car Dealership] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Car Dealership] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Car Dealership] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Car Dealership] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Car Dealership] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Car Dealership] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Car Dealership] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Car Dealership] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Car Dealership] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Car Dealership] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Car Dealership] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Car Dealership] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Car Dealership] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Car Dealership] SET  MULTI_USER 
GO
ALTER DATABASE [Car Dealership] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Car Dealership] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Car Dealership] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Car Dealership] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [Car Dealership] SET DELAYED_DURABILITY = DISABLED 
GO
USE [Car Dealership]
GO
/****** Object:  Table [dbo].[Car]    Script Date: 6/1/2022 2:56:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Car](
	[id] [int] NOT NULL,
	[Category] [nvarchar](50) NULL,
	[Model] [nvarchar](50) NULL,
	[Year] [int] NULL,
	[SerialNumber] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[DealershipEstate]    Script Date: 6/1/2022 2:56:25 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Role]    Script Date: 6/1/2022 2:56:25 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SalesInvoice]    Script Date: 6/1/2022 2:56:25 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SalesPerson]    Script Date: 6/1/2022 2:56:25 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[User]    Script Date: 6/1/2022 2:56:25 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[User](
	[id] [int] NOT NULL,
	[FirstName] [nvarchar](50) NULL,
	[LastName] [nvarchar](50) NULL,
	[PhoneNumber] [int] NULL,
	[City] [nvarchar](50) NULL,
	[Address] [nvarchar](50) NULL,
	[State/Province] [nvarchar](50) NULL,
	[PostalCode] [int] NULL,
	[Email] [nvarchar](50) NULL,
	[UserName] [nvarchar](50) NULL,
	[Password] [nvarchar](50) NULL,
	[Car_id] [int] NULL,
PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[UserRole]    Script Date: 6/1/2022 2:56:25 PM ******/
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
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Car] ([id], [Category], [Model], [Year], [SerialNumber]) VALUES (1, N'Sedan', N'A8', 2018, 11)
GO
INSERT [dbo].[User] ([id], [FirstName], [LastName], [PhoneNumber], [City], [Address], [State/Province], [PostalCode], [Email], [UserName], [Password], [Car_id]) VALUES (1, N'Ilia', N'Marinov', 11223344, N'Sofia', N'Sofia', N'Sofia', 8000, N'iliikata@bg', N'iliikata', N'123456789', 1)
GO
INSERT [dbo].[User] ([id], [FirstName], [LastName], [PhoneNumber], [City], [Address], [State/Province], [PostalCode], [Email], [UserName], [Password], [Car_id]) VALUES (2, N'Stoqn', N'Ponchev', 123, N'Burgas', N'Burgas', N'Burgas', 8000, N'stoqn@bg', N'Stoqncho', N'1234', NULL)
GO
INSERT [dbo].[User] ([id], [FirstName], [LastName], [PhoneNumber], [City], [Address], [State/Province], [PostalCode], [Email], [UserName], [Password], [Car_id]) VALUES (3, N'Petar', N'Petkov', 1234, N'Burgas', N'Burgas', N'Burgas', 8000, N'petar@bg', N'petar', N'123456', NULL)
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
REFERENCES [dbo].[Car] ([id])
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
