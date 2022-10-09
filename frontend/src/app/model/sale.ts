
export type Sale = {
  saleId: number,
  productName: string,
  saleDateTime: string,
  quantity: number,
  avgUnitPrice: number,
  salesPersonFirstName: string,
  salesPersonLastName: string
}

export type ReportSaleRequest = {
  productName: string,
  quantity: number,
  unitPrice: number,
  contractId: string,
  userId: number,
}
