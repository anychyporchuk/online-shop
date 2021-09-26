export class ProductMeta {
    key: string = '';
    value: string = '';
}

export class Product {
    title: string = '';
    price: number = 0;
    imageUrl: string = '';
    metas: ProductMeta[] = [];
}

export class Pagination {
    page: number = 1;
    limit: number = 1;
}

export class PaginatedResult<T> {
    result?: T;
    pagination?: Pagination;
}